import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SourceView extends JFrame implements ActionListener{
	JTabbedPane tp = new JTabbedPane();
	
	JPanel paneTop = new JPanel(new BorderLayout());
		JLabel lbl = new JLabel(" URL ");
		JTextField tf = new JTextField(20);
		JButton btn = new JButton("소스보기");
	
	JTextArea ta = new JTextArea();
	public SourceView() {
		paneTop.add(BorderLayout.WEST, lbl);
		paneTop.add(BorderLayout.CENTER, tf);
		paneTop.add(BorderLayout.EAST, btn);
		add("North",paneTop);
		add(tp);
		//add("Center",ta);
		
		setSize(1000,1000);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		tf.addActionListener(this);
		btn.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae) {
		try {
			Object obj = ae.getSource();
			if(tf.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "값을 넣어라");
			}else {
				if(obj == btn || obj == tf) {//버튼 클릭시 이벤트
					//			https://www.nate.com
					URL url = new URL(tf.getText());
					
					URLConnection con = url.openConnection();
					con.connect();
					
					String contentType = con.getContentType();
					String encode = contentType.substring(contentType.indexOf("=")+1);
					
//					InputStream is = url.openStream();
//					InputStreamReader isr = new InputStreamReader(is, encode);
					BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), encode));
					
					JTextArea ta = new JTextArea();
					JScrollPane sp = new JScrollPane(ta);
					tp.addTab(tf.getText(), sp);
					while(true) {
						String inData = br.readLine();
						if(inData == null) break;
						ta.append(inData+"\n");
					}
				}	
				ta.setText("");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new SourceView();
	}

}
