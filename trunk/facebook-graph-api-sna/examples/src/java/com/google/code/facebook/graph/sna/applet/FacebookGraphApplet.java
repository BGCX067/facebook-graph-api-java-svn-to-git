/*
 * Copyright (c) 2003, the JUNG Project and the Regents of the University of
 * California All rights reserved.
 * 
 * This software is open-source under the BSD license; see either "license.txt"
 * or http://jung.sourceforge.net/license.txt for a description.
 * 
 */
package com.google.code.facebook.graph.sna.applet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.ObjectInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.apache.commons.collections15.Transformer;

import com.google.code.facebook.graph.model.Entity;
import com.google.code.facebook.graph.model.GraphNode;
import com.google.code.facebook.graph.model.enumeration.ConnectionEnum;
import com.google.code.facebook.graph.model.enumeration.FieldEnum;
import com.google.code.facebook.graph.model.enumeration.ObjectType;
import com.google.code.facebook.graph.sna.service.GraphAdapter;
import com.google.code.facebook.graph.sna.service.jung.EdgeAdapter;
import com.google.code.facebook.graph.sna.service.jung.JungGraphAdapter;

import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.GraphZoomScrollPane;
import edu.uci.ics.jung.visualization.LayeredIcon;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.CrossoverScalingControl;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ScalingControl;
import edu.uci.ics.jung.visualization.decorators.DefaultVertexIconTransformer;
import edu.uci.ics.jung.visualization.decorators.EllipseVertexShapeTransformer;
import edu.uci.ics.jung.visualization.decorators.PickableEdgePaintTransformer;
import edu.uci.ics.jung.visualization.decorators.PickableVertexPaintTransformer;
import edu.uci.ics.jung.visualization.decorators.VertexIconShapeTransformer;
import edu.uci.ics.jung.visualization.picking.PickedState;
import edu.uci.ics.jung.visualization.renderers.Checkmark;
import edu.uci.ics.jung.visualization.renderers.DefaultEdgeLabelRenderer;
import edu.uci.ics.jung.visualization.renderers.DefaultVertexLabelRenderer;
import edu.uci.ics.jung.visualization.transform.LayoutLensSupport;
import edu.uci.ics.jung.visualization.transform.LensSupport;
import edu.uci.ics.jung.visualization.transform.shape.MagnifyImageLensSupport;


/**
 * Demonstrates the use of images to represent graph vertices.
 * The images are added to the DefaultGraphLabelRenderer and can
 * either be offset from the vertex, or centered on the vertex.
 * Additionally, the relative positioning of the label and
 * image is controlled by subclassing the DefaultGraphLabelRenderer
 * and setting the appropriate properties on its JLabel superclass
 *  FancyGraphLabelRenderer
 * 
 * The images used in this demo (courtesy of slashdot.org) are
 * rectangular but with a transparent background. When vertices
 * are represented by these images, it looks better if the actual
 * shape of the opaque part of the image is computed so that the
 * edge arrowheads follow the visual shape of the image. This demo
 * uses the FourPassImageShaper class to compute the Shape from
 * an image with transparent background.
 * 
 * @author Tom Nelson
 * 
 */
public class FacebookGraphApplet extends JApplet {

	   /**
	 * 
	 */
	private static final long serialVersionUID = 5432239991020505763L;
	
	private static final Set<ObjectType> DISPLAYABLE_ENTITIES = EnumSet.of(ObjectType.EVENT, ObjectType.GROUP, ObjectType.PAGE, ObjectType.USER);

	/**
     * the graph
     */
    Graph<Entity<FieldEnum, ConnectionEnum>, EdgeAdapter<ConnectionEnum>> graph;

    /**
     * the visual component and renderer for the graph
     */
    VisualizationViewer<Entity<FieldEnum, ConnectionEnum>, EdgeAdapter<ConnectionEnum>> vv;
    
    LensSupport viewSupport;
    LensSupport modelSupport;
    LensSupport magnifyLayoutSupport;
    LensSupport magnifyViewSupport;
    /**
     * create an instance of a simple graph with controls to
     * demo the zoom features.
     * 
     */
    @Override
    public void init() {
    	super.init();
        // create a simple graph for the demo
        fetchUserGraph();
        final Collection<? extends Entity<FieldEnum, ConnectionEnum>> vertices = graph.getVertices();
        
        // a Map for the labels
        Map<Entity<FieldEnum, ConnectionEnum>, String> map = new HashMap<Entity<FieldEnum, ConnectionEnum>,String>();
        Iterator<? extends Entity<FieldEnum, ConnectionEnum>> iterator = vertices.iterator();
        while (iterator.hasNext()) {
            Entity<FieldEnum, ConnectionEnum> entity = iterator.next();
			map.put(entity, entity.getLabel());
        }
        
        FRLayout<Entity<FieldEnum, ConnectionEnum>, EdgeAdapter<ConnectionEnum>> layout = new FRLayout<Entity<FieldEnum, ConnectionEnum>, EdgeAdapter<ConnectionEnum>>((Graph<Entity<FieldEnum, ConnectionEnum>, EdgeAdapter<ConnectionEnum>>) graph);
        layout.setMaxIterations(100);
        vv =  new VisualizationViewer<Entity<FieldEnum, ConnectionEnum>, EdgeAdapter<ConnectionEnum>>(layout, new Dimension(2000,2000));
        
        Transformer<Entity<FieldEnum, ConnectionEnum>,Paint> vpf = 
            new PickableVertexPaintTransformer<Entity<FieldEnum, ConnectionEnum>>(vv.getPickedVertexState(), Color.white, Color.yellow);
        vv.getRenderContext().setVertexFillPaintTransformer(vpf);
        vv.getRenderContext().setEdgeDrawPaintTransformer(new PickableEdgePaintTransformer<EdgeAdapter<ConnectionEnum>>(vv.getPickedEdgeState(), Color.black, Color.cyan));

        vv.setBackground(Color.white);
        
        // a Map for the Icons
        final Map<Entity<FieldEnum, ConnectionEnum>, Icon> iconMap = new HashMap<Entity<FieldEnum, ConnectionEnum>,Icon>();
        new Thread(new Runnable() {
			public void run() {
				Iterator<? extends Entity<FieldEnum, ConnectionEnum>> iterator = vertices.iterator();
		        while (iterator.hasNext()) {
		            try {
		            	Entity<FieldEnum, ConnectionEnum> entity = iterator.next();
//		            	Icon icon = 
//		            		new LayeredIcon(new ImageIcon("http://facebookgraph.appspot.com/proxy?url=" + entity.getPicture(PictureType.SQUARE), "Profile Picture").getImage());
//		              	iconMap.put(entity, icon);
		            	
		                Image image =  getImageFromEntity(entity);
		                if (image != null && image.getWidth(null) > 0 && image.getHeight(null) > 0) {
		    				Icon icon = 
		                        new LayeredIcon(image);
		                    iconMap.put(entity, icon);
		                    if ((iconMap.size() % 5) == 0) {
		                    	vv.repaint();		                    	
		                    }
		                }
		            } catch(Exception ex) {
		            	ex.printStackTrace();
		            }
		        }
		        vv.repaint();
			}
        	
        }).start();
        
        final Transformer<Entity<FieldEnum, ConnectionEnum>,String> vertexStringerImpl = 
            new VertexStringerImpl<Entity<FieldEnum, ConnectionEnum>>(map);
        Transformer<EdgeAdapter<ConnectionEnum>,String> edgeStringerImpl = new Transformer<EdgeAdapter<ConnectionEnum>,String>(){
			public String transform(EdgeAdapter<ConnectionEnum> edge) {
				return edge.toString();
			}
        };
        vv.getRenderContext().setEdgeLabelTransformer(edgeStringerImpl);
        vv.getRenderContext().setVertexLabelTransformer(vertexStringerImpl);
        vv.getRenderContext().setVertexLabelRenderer(new DefaultVertexLabelRenderer(Color.cyan));
        vv.getRenderContext().setEdgeLabelRenderer(new DefaultEdgeLabelRenderer(Color.cyan));
        
        
        // features on and off. For a real application, use VertexIconAndShapeFunction instead.
        final VertexIconShapeTransformer<Entity<FieldEnum, ConnectionEnum>> vertexImageShapeFunction =
            new VertexIconShapeTransformer<Entity<FieldEnum, ConnectionEnum>>(new EllipseVertexShapeTransformer<Entity<FieldEnum, ConnectionEnum>>());

        final DefaultVertexIconTransformer<Entity<FieldEnum, ConnectionEnum>> vertexIconFunction =
        	new DefaultVertexIconTransformer<Entity<FieldEnum, ConnectionEnum>>();
        
        vertexImageShapeFunction.setIconMap(iconMap);
        vertexIconFunction.setIconMap(iconMap);
        
        vv.getRenderContext().setVertexShapeTransformer(vertexImageShapeFunction);
        vv.getRenderContext().setVertexIconTransformer(vertexIconFunction);

        
        // Get the pickedState and add a listener that will decorate the
        // Vertex images with a checkmark icon when they are picked
        PickedState<Entity<FieldEnum, ConnectionEnum>> ps = vv.getPickedVertexState();
        ps.addItemListener(new PickWithIconListener(vertexIconFunction));
        
        // add a listener for ToolTips
        vv.setVertexToolTipTransformer(new Transformer<Entity<FieldEnum, ConnectionEnum>, String>(){
			@Override
			public String transform(Entity<FieldEnum, ConnectionEnum> entity) {
				return entity.getDescription();
			}
        });
        
        Container content = getContentPane();
        final GraphZoomScrollPane panel = new GraphZoomScrollPane(vv);
        content.add(panel);
        
        final DefaultModalGraphMouse graphMouse = new DefaultModalGraphMouse();
        vv.setGraphMouse(graphMouse);
        
        
        final ScalingControl scaler = new CrossoverScalingControl();

        JButton plus = new JButton("+");
        plus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                scaler.scale(vv, 1.1f, vv.getCenter());
            }
        });
        JButton minus = new JButton("-");
        minus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                scaler.scale(vv, 1/1.1f, vv.getCenter());
            }
        });
        
        JComboBox modeBox = graphMouse.getModeComboBox();
        JPanel modePanel = new JPanel();
        modePanel.setBorder(BorderFactory.createTitledBorder("Mouse Mode"));
        modePanel.add(modeBox);
        
        JPanel scaleGrid = new JPanel(new GridLayout(1,0));
        scaleGrid.setBorder(BorderFactory.createTitledBorder("Zoom"));
        JPanel controls = new JPanel();
        scaleGrid.add(plus);
        scaleGrid.add(minus);
        controls.add(scaleGrid);

        controls.add(modePanel);
        content.add(controls, BorderLayout.SOUTH);
        
        this.viewSupport = new MagnifyImageLensSupport<Entity<FieldEnum, ConnectionEnum>, EdgeAdapter<ConnectionEnum>>(vv);
//        	new ViewLensSupport<Number,Number>(vv, new HyperbolicShapeTransformer(vv, 
//        		vv.getRenderContext().getMultiLayerTransformer().getTransformer(Layer.VIEW)), 
//                new ModalLensGraphMouse());

        this.modelSupport = new LayoutLensSupport<Entity<FieldEnum, ConnectionEnum>, EdgeAdapter<ConnectionEnum>>(vv);
        
        graphMouse.addItemListener(modelSupport.getGraphMouse().getModeListener());
        graphMouse.addItemListener(viewSupport.getGraphMouse().getModeListener());

        ButtonGroup radio = new ButtonGroup();
        JRadioButton none = new JRadioButton("None");
        none.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e) {
                if(viewSupport != null) {
                    viewSupport.deactivate();
                }
                if(modelSupport != null) {
                    modelSupport.deactivate();
                }
            }
        });
        none.setSelected(true);

        JRadioButton hyperView = new JRadioButton("View");
        hyperView.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e) {
                viewSupport.activate(e.getStateChange() == ItemEvent.SELECTED);
            }
        });

        JRadioButton hyperModel = new JRadioButton("Layout");
        hyperModel.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e) {
                modelSupport.activate(e.getStateChange() == ItemEvent.SELECTED);
            }
        });
        radio.add(none);
        radio.add(hyperView);
        radio.add(hyperModel);
        
        JMenuBar menubar = new JMenuBar();
        JMenu modeMenu = graphMouse.getModeMenu();
        menubar.add(modeMenu);

        JPanel lensPanel = new JPanel(new GridLayout(2,0));
        lensPanel.setBorder(BorderFactory.createTitledBorder("Lens"));
        lensPanel.add(none);
        lensPanel.add(hyperView);
        lensPanel.add(hyperModel);
        controls.add(lensPanel);
    }


	private Image getImageFromEntity(Entity<FieldEnum, ConnectionEnum> entity) {
		if (DISPLAYABLE_ENTITIES.contains(entity.getType())) {
			try {
	            URL               url     = new URL("http://facebookgraph.appspot.com/proxy?url=" + encodeUrl(entity.getPicture()));
	            HttpURLConnection request = (HttpURLConnection) url.openConnection();
	            
	            request.connect();
	            
	            if (request.getResponseCode() == HttpURLConnection.HTTP_OK) {
	            	BufferedImage image = ImageIO.read(request.getInputStream());
	            	return Toolkit.getDefaultToolkit().createImage(image.getSource()); 
	            }
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}


	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	private void fetchUserGraph() {
		try {
			String accessToken = getParameter("accessToken");
	        URL               url     = new URL("http://facebookgraph.appspot.com/fetchGraph?accessToken=" + encodeUrl(accessToken));
	        HttpURLConnection request = (HttpURLConnection) url.openConnection();
	        
	        request.connect();
	        
	        if (request.getResponseCode() == HttpURLConnection.HTTP_OK) {
	        	GraphAdapter<Graph<Entity<FieldEnum, ConnectionEnum>, EdgeAdapter<ConnectionEnum>>, Entity<FieldEnum, ConnectionEnum>, ConnectionEnum> adapter = new JungGraphAdapter<Entity<FieldEnum, ConnectionEnum>, ConnectionEnum>(); 
	        	ObjectInputStream is = new ObjectInputStream(new GZIPInputStream(request.getInputStream()));
	        	graph = adapter.adaptFrom((GraphNode<? extends FieldEnum, ConnectionEnum>) is.readObject());
	        	is.close();
	        }
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
    
    /**
     * A simple implementation of VertexStringer that
     * gets Vertex labels from a Map  
     * 
     * @author Tom Nelson 
     *
     *
     */
    class VertexStringerImpl<V> implements Transformer<V,String> {

        Map<V,String> map = new HashMap<V,String>();
        
        boolean enabled = true;
        
        public VertexStringerImpl(Map<V,String> map) {
            this.map = map;
        }
        
        /**
         * @see edu.uci.ics.jung.graph.decorators.VertexStringer#getLabel(edu.uci.ics.jung.graph.Vertex)
         */
        public String transform(V v) {
            if(isEnabled()) {
                return map.get(v);
            } else {
                return "";
            }
        }

        /**
         * @return Returns the enabled.
         */
        public boolean isEnabled() {
            return enabled;
        }

        /**
         * @param enabled The enabled to set.
         */
        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }
    }
    
    private String encodeUrl(String url) {
    	try {
			return URLEncoder.encode(url, "UTF-8");
		} catch (Exception e) {
			return url;
		}
    }
    
    public static class PickWithIconListener implements ItemListener {
        DefaultVertexIconTransformer<Entity<FieldEnum, ConnectionEnum>> imager;
        Icon checked;
        
        public PickWithIconListener(DefaultVertexIconTransformer<Entity<FieldEnum, ConnectionEnum>> vertexIconFunction) {
            this.imager = vertexIconFunction;
            checked = new Checkmark(Color.red);
        }

        @SuppressWarnings("unchecked")
		public void itemStateChanged(ItemEvent e) {
            Icon icon = imager.transform((Entity<FieldEnum, ConnectionEnum>)e.getItem());
            if(icon != null && icon instanceof LayeredIcon) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    ((LayeredIcon)icon).add(checked);
                } else {
                    ((LayeredIcon)icon).remove(checked);
                }
            }
        }
    }


    /**
     * a driver for this demo
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Container content = frame.getContentPane();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        FacebookGraphApplet applet = new FacebookGraphApplet();
        applet.init();

        content.add(applet);
        frame.pack();
        frame.setVisible(true);
    }
}
