package com.mycompany.covidtracker;

// importing important library and classes [ mga need na library ]
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 *
 * @author Kristine
 */
public class main {
    
    //code sa paag gawa ng GUI 
    public static void cFrame(String location, String ac, String cc, String r, String d, String[] cityList, String[] covidCases, String[] totalList) {

        //main frame or Main window
        JFrame frame = new JFrame("Covid Tracker");
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Kristine\\Documents\\NetBeansProjects\\CovidTracker\\src\\main\\java\\com\\mycompany\\covidtracker\\covid 19.png");
        frame.setIconImage(icon);
        frame.setLayout(null);
        frame.setSize(825, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        //header 
        JLabel headerText = new JLabel();
        headerText.setText("<html> <font color=#3355FF size=12> <center> COVID-19 cases in " + location + " </center> </font> <font color=#FFFFFF size=3><br> " + totalList[5] + " </font><html>");
        headerText.setVerticalAlignment(JLabel.TOP);
        headerText.setHorizontalAlignment(JLabel.LEFT);
        headerText.setBounds(25, 30, 900, 900);

        // active cases text
        JLabel activeCases = new JLabel();
        activeCases.setText("<html> <center><font color=#FFFFFF size=6> Active Cases </font> <br> <br> <font color=#FFFFFF size=8 > " + ac + "</center> </font> </center> </html>");
        activeCases.setVerticalAlignment(JLabel.TOP);
        activeCases.setHorizontalAlignment(JLabel.CENTER);
        activeCases.setBounds(25, 100, 900, 900);

        // confirmed cases text
        JLabel confirmedCases = new JLabel();
        confirmedCases.setText("<html> <center> <font color=#FFFFFF size=6> Confirmed Cases </font><br> <br> <font color=#FFFFFF size=8 > " + cc + "</font> </center> </html>");
        confirmedCases.setVerticalAlignment(JLabel.TOP);
        confirmedCases.setHorizontalAlignment(JLabel.CENTER);

        // recovered cases text
        JLabel Recovered = new JLabel();
        Recovered.setText("<html> <center> <font color=#FFFFFF size=6> Recovered </font> <br> <br> <br> <br> <font color=#FFFFFF size=8>  " + r + "  </font> </center></html>");
        Recovered.setVerticalAlignment(JLabel.TOP);
        Recovered.setHorizontalAlignment(JLabel.CENTER);

        // deaths cases text
        JLabel Deaths = new JLabel();
        Deaths.setText("<html> <center> <font color=#FFFFFF size=6> Deaths </font> <br> <br> <br> <br> <font color=#FFFFFF size=8> " + d + "  </font></center> </html>");
        Deaths.setVerticalAlignment(JLabel.TOP);
        Deaths.setHorizontalAlignment(JLabel.CENTER);

        //custom color for text and panel background
        Color matteRed = new Color(198, 0, 0);
        Color matteBrown = new Color(128, 0, 0);
        Color matteGreen = new Color(24, 136, 15);
        Color matteBLue = new Color(16, 101, 125);
        Color matteYellow = new Color(255, 0, 0);
        Color darkGreen = new Color(42, 94, 80);

        //panel box for active cases 
        JPanel activeCasesPanel = new JPanel();
        activeCasesPanel.setBackground(matteRed);
        activeCasesPanel.setBounds(25, 150, 150, 150);
        activeCasesPanel.setLayout(new BorderLayout());
        activeCasesPanel.add(activeCases);

        //panel box for confirmed cases 
        JPanel confirmedCasesPanel = new JPanel();
        confirmedCasesPanel.setBackground(matteBrown);
        confirmedCasesPanel.setBounds(225, 150, 150, 150);
        confirmedCasesPanel.setLayout(new BorderLayout());
        confirmedCasesPanel.add(confirmedCases);

        //panel box for recovered cases
        JPanel recoveredPanel = new JPanel();
        recoveredPanel.setBackground(matteGreen);
        recoveredPanel.setBounds(425, 150, 150, 150);
        recoveredPanel.setLayout(new BorderLayout());
        recoveredPanel.add(Recovered);

        //panel box for deaths
        JPanel deathPanel = new JPanel();
        deathPanel.setBackground(matteBLue);
        deathPanel.setBounds(625, 150, 150, 150);
        deathPanel.setLayout(new BorderLayout());
        deathPanel.add(Deaths);

        //learn more button
        JButton btn3 = new JButton("Learn more");
        btn3.setBackground(matteGreen);
        btn3.setForeground(Color.WHITE);
        btn3.setOpaque(true);
        btn3.setBounds(25, 330, 130, 30);

        //choose city button
        JButton btn2 = new JButton("Choose city");
        btn2.setBackground(matteYellow);
        btn2.setForeground(Color.WHITE);
        btn2.setOpaque(true);
        btn2.setBounds(540, 330, 130, 30);

        // exit button
        JButton btn1 = new JButton("Exit");
        btn1.setBackground(darkGreen);
        btn1.setForeground(Color.WHITE);
        btn1.setOpaque(true);
        btn1.setBounds(680, 330, 100, 30);

        //background iamge
        ImageIcon background = new ImageIcon("C:\\Users\\Kristine\\Documents\\NetBeansProjects\\CovidTracker\\src\\main\\java\\com\\mycompany\\covidtracker\\a.png");
        Image img = background.getImage();
        Image temp = img.getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        background = new ImageIcon(temp);
        JLabel back = new JLabel(background);
        back.setLayout(null);
        back.setBounds(0, 0, 825, 400);

        //code will run if button 3 [ learn more ] push
        btn3.addActionListener((ActionEvent e) -> {
            JFrame f = new JFrame();
            f.setIconImage(icon);
            f.setLayout(null);
            f.setSize(400, 400);
            f.setLocationRelativeTo(null);
            f.setResizable(false);

            JEditorPane jep = new JEditorPane("text/html",
                    "<html><font color=#000000 size=3>Official Links:<br><br>"
                    + " Department of Health (DOH) <br> <a href='1'>https://doh.gov.ph/</a> <br><br>"
                    + " Licensed Covid-19 Testing Laboratories in the Philippines <br> <a href='2'>https://doh.gov.ph/licensed-covid-19-testing-laboratories</a><br><br>"
                    + " DOH vetted 3rd Party Telemedicine Service Providers<br> <a href='3'>https://doh.gov.ph/List-of-DOH-vetted-3rd-Party-Telemedicine-Service-Providers</a><br><br>"
                    + " World Health Organization Covid prevention and Systoms <br> <a href='4'>https://www.who.int/health-topics/coronavirus#tab=tab_1</a><br><br>"
                    + "</font></html>");

            jep.setEditable(false);
            jep.setOpaque(false);
            jep.setBounds(0, 0, 400, 400);
            jep.addHyperlinkListener(new HyperlinkListener() {
                public void hyperlinkUpdate(HyperlinkEvent hle) {
                    if (HyperlinkEvent.EventType.ACTIVATED.equals(hle.getEventType())) {
                        switch (hle.getDescription()) {
                            case "1":
                                System.out.println("PDF");
                                break;
                            case "2":
                                System.out.println("PDF1");
                                break;
                            case "3":
                                System.out.println("PDF2");
                                break;
                            case "4":
                                System.out.println("PDF3");
                                break;
                            default:
                                break;
                        }

                    }
                }
            });
            f.add(jep);
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setVisible(true);
        });

        //code will run if button 1 [ Exit ] push
        btn1.addActionListener((ActionEvent e) -> {
            frame.dispose();
        });

        //code will run if button 2 [ Choose city ] push
        btn2.addActionListener((ActionEvent e) -> {

            frame.dispose();

            //Select City GUI
            Object selectedCity = JOptionPane.showInputDialog(null,
                    "Cumulative COVID-19 cases in Metro Manila \n\nChoose City:",
                    "COVID-19 CASES UPDATE",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    cityList,
                    "Valenzuela"
            );

            int covidCasesIndex = Arrays.asList(covidCases).indexOf(selectedCity);

            cFrame(covidCases[covidCasesIndex].toUpperCase(),
                    covidCases[covidCasesIndex + 1],
                    covidCases[covidCasesIndex + 2],
                    covidCases[covidCasesIndex + 3],
                    covidCases[covidCasesIndex + 4],
                    cityList,
                    covidCases,
                    totalList
            );
        });

        //putting all button and panels in main frame
        frame.add(headerText);
        frame.add(activeCasesPanel);
        frame.add(confirmedCasesPanel);
        frame.add(recoveredPanel);
        frame.add(deathPanel);
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        frame.add(back);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    
    //main method parang index.html
    public static void main(String[] args) throws IOException {

        //covidCases array variable
        String[] covidCases = {};
        ArrayList<String> covidCasesArrayList = new ArrayList<>(Arrays.asList(covidCases));

        //citylist array variable
        String[] cityList = {};
        ArrayList<String> cityArrayList = new ArrayList<>(Arrays.asList(cityList));

        //total cases array variable
        String[] totalList = {};
        ArrayList<String> totalArrayList = new ArrayList<>(Arrays.asList(totalList));

        //get data from wikipedia
        Document doc1 = Jsoup.connect("https://en.wikipedia.org/wiki/COVID-19_pandemic_in_Metro_Manila?oldformat=true").get();

        Elements body = doc1.select("table.wikitable.sortable");

        // get covid cases by city a
        for (Element e : body.select("tr")) {

            String LGU = e.select("td:nth-of-type(1)").text();//Local Goverment Unit
            covidCasesArrayList.add(LGU);
            cityArrayList.add(LGU);

            String Cases = e.select("td:nth-of-type(2)").text();
            covidCasesArrayList.add(Cases);

            String Deaths = e.select("td:nth-of-type(3)").text();
            covidCasesArrayList.add(Deaths);

            String Recov = e.select("td:nth-of-type(4)").text();
            covidCasesArrayList.add(Recov);

            String Active = e.select("td:nth-of-type(5)").text();
            covidCasesArrayList.add(Active);

        }

        // get total covid cases in metro manila
        Elements footer = body.select("tr.sortbottom");

        String total = footer.select("th:nth-of-type(1)").text();
        totalArrayList.add(total);

        String TCases = footer.select("th:nth-of-type(2)").text();
        totalArrayList.add(TCases);

        String TDeaths = footer.select("th:nth-of-type(3)").text();
        totalArrayList.add(TDeaths);

        String TRecov = footer.select("th:nth-of-type(4)").text();
        totalArrayList.add(TRecov);

        String TActive = footer.select("th:nth-of-type(5)").text();
        totalArrayList.add(TActive);

        String caption = body.select("caption").text();
        totalArrayList.add(caption);

        //cities arraylist to array
        cityList = cityArrayList.toArray(cityList);
        //cities arraylist to array
        covidCases = covidCasesArrayList.toArray(covidCases);
        //totalCases arraylist to array        

        totalList = totalArrayList.toArray(totalList);
        System.out.println(totalArrayList);

        //calling gui code [ fFrame ]
        cFrame("Metro Manila",
                totalList[4],
                totalList[1],
                totalList[3],
                totalList[2],
                cityList,
                covidCases,
                totalList
        );
    }
}
