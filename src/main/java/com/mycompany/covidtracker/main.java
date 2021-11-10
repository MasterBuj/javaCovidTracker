package com.mycompany.covidtracker;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Image;

/**
 *
 * @author Kristine
 */
public class main {

    public static void cFrame(String location, String ac, String cc, String r, String d, String[] cityList, String[] covidCases, String[] totalList) {

        //main frame
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(825, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JLabel headerText = new JLabel();
        headerText.setText("<html> <font color=#3355FF size=12> <center> COVID-19 cases in " + location + " </center> </font> <font color=#FFFFFF size=3><br> " + totalList[5] + " </font><html>");
        headerText.setVerticalAlignment(JLabel.TOP);
        headerText.setHorizontalAlignment(JLabel.LEFT);
        headerText.setBounds(25, 30, 900, 900);

        JLabel activeCases = new JLabel();
        activeCases.setText("<html> <center><font color=#FFFFFF size=6> Active Cases </font> <br> <br> <font color=#FFFFFF size=8 > " + ac + "</center> </font> </center> </html>");
        activeCases.setVerticalAlignment(JLabel.TOP);
        activeCases.setHorizontalAlignment(JLabel.CENTER);
        activeCases.setBounds(25, 100, 900, 900);

        JLabel confirmedCases = new JLabel();
        confirmedCases.setText("<html> <center> <font color=#FFFFFF size=6> Confirmed Cases </font><br> <br> <font color=#FFFFFF size=8 > " + cc + "</font> </center> </html>");
        confirmedCases.setVerticalAlignment(JLabel.TOP);
        confirmedCases.setHorizontalAlignment(JLabel.CENTER);

        JLabel Recovered = new JLabel();
        Recovered.setText("<html> <center> <font color=#FFFFFF size=6> Recovered </font> <br> <br> <br> <br> <font color=#FFFFFF size=8>  " + r + "  </font> </center></html>");
        Recovered.setVerticalAlignment(JLabel.TOP);
        Recovered.setHorizontalAlignment(JLabel.CENTER);

        JLabel Deaths = new JLabel();
        Deaths.setText("<html> <center> <font color=#FFFFFF size=6> Deaths </font> <br> <br> <br> <br> <font color=#FFFFFF size=8> " + d + "  </font></center> </html>");
        Deaths.setVerticalAlignment(JLabel.TOP);
        Deaths.setHorizontalAlignment(JLabel.CENTER);

        //custom color
        Color matteRed = new Color(198, 0, 0);
        Color matteBrown = new Color(128, 0, 0);
        Color matteGreen = new Color(24, 136, 15);
        Color matteBLue = new Color(16, 101, 125);

        //panel for active cases
        JPanel activeCasesPanel = new JPanel();
        activeCasesPanel.setBackground(matteRed);
        activeCasesPanel.setBounds(25, 150, 150, 150);
        activeCasesPanel.setLayout(new BorderLayout());
        activeCasesPanel.add(activeCases);

        //panel for confirmed cases
        JPanel confirmedCasesPanel = new JPanel();
        confirmedCasesPanel.setBackground(matteBrown);
        confirmedCasesPanel.setBounds(225, 150, 150, 150);
        confirmedCasesPanel.setLayout(new BorderLayout());
        confirmedCasesPanel.add(confirmedCases);

        //panel for death
        JPanel recoveredPanel = new JPanel();
        recoveredPanel.setBackground(matteGreen);
        recoveredPanel.setBounds(425, 150, 150, 150);
        recoveredPanel.setLayout(new BorderLayout());
        recoveredPanel.add(Recovered);

        //panel for death
        JPanel deathPanel = new JPanel();
        deathPanel.setBackground(matteBLue);
        deathPanel.setBounds(625, 150, 150, 150);
        deathPanel.setLayout(new BorderLayout());
        deathPanel.add(Deaths);

        //add a button
        JButton btn2 = new JButton("Choose city");
        btn2.setBounds(540, 330, 130, 30);

        JButton btn1 = new JButton("Exit");
        btn1.setBounds(680, 330, 100, 30);

        //background iamge
        ImageIcon background = new ImageIcon("C:\\Users\\Kristine\\Documents\\NetBeansProjects\\CovidTracker\\src\\main\\java\\com\\mycompany\\covidtracker\\a.png");
        Image img = background.getImage();
        Image temp = img.getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        background = new ImageIcon(temp);
        JLabel back = new JLabel(background);
        back.setLayout(null);
        back.setBounds(0, 0, 825, 400);

        //add an action listener to the button
        btn1.addActionListener((ActionEvent e) -> {
            frame.dispose();
        });

        btn2.addActionListener((ActionEvent e) -> {

            frame.dispose();

            //Select City GUI
            Object selectedCity = JOptionPane.showInputDialog(null,
                    "Choose City:",
                    "COVID-19 CASES UPDATE",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    cityList,
                    "Valenzuela"
            );

            //find index slected city
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

        frame.add(headerText);
        frame.add(activeCasesPanel);
        frame.add(confirmedCasesPanel);
        frame.add(recoveredPanel);
        frame.add(deathPanel);
        frame.add(btn1);
        frame.add(btn2);
        frame.add(back);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws IOException {

        String[] covidCases = {};
        ArrayList<String> covidCasesArrayList = new ArrayList<>(Arrays.asList(covidCases));

        String[] cityList = {};
        ArrayList<String> cityArrayList = new ArrayList<>(Arrays.asList(cityList));

        String[] totalList = {};
        ArrayList<String> totalArrayList = new ArrayList<>(Arrays.asList(totalList));

        try {
//            Document doc1 = Jsoup.connect("https://en.wikipedia.org/wiki/COVID-19_pandemic_in_Metro_Manila?oldformat=true").get();

        } catch (Exception e) {
        }

        String html = "<table class=\"wikitable sortable plainrowheaders floatright\" style=\"text-align:left; font-size:90%; width:auto; clear:right; margin:0 0 0.5em 1em;\"> <caption> Cumulative COVID-19 cases in Metro Manila<sup id=\"cite_ref-COVID-19_tracker_5-1\" class=\"reference\"><a href=\"#cite_note-COVID-19_tracker-5\">[4]</a></sup> <br><span style=\"font-size:85%;\">based on numbers confirmed and validated by the LGU<br>Updated November 1, 2021</span> </caption> <tbody> <tr> <th><abbr title=\"Local government unit\">LGU</abbr> </th> <th><abbr title=\"Confirmed cases\">Cases</abbr> </th> <th>Deaths </th> <th><abbr title=\"Recoveries\">Recov.</abbr> </th> <th><abbr title=\"Active cases\">Active</abbr> </th> </tr> <tr> <td><a href=\"/wiki/Caloocan\" title=\"Caloocan\">Caloocan</a> </td> <td style=\"text-align:right;\">60,744 </td> <td style=\"text-align:right;\">1,558 </td> <td style=\"text-align:right;\">58,696 </td> <td style=\"text-align:right;\">490 </td> </tr> <tr> <td><a href=\"/wiki/Las_Pi%C3%B1as\" title=\"Las Piñas\">Las Piñas</a> </td> <td style=\"text-align:right;\">25,260 </td> <td style=\"text-align:right;\">557 </td> <td style=\"text-align:right;\">24,564 </td> <td style=\"text-align:right;\">139 </td> </tr> <tr> <td><a href=\"/wiki/Makati\" title=\"Makati\">Makati</a> </td> <td style=\"text-align:right;\">44,746 </td> <td style=\"text-align:right;\">962 </td> <td style=\"text-align:right;\">43,462 </td> <td style=\"text-align:right;\">322 </td> </tr> <tr> <td><a href=\"/wiki/Malabon\" title=\"Malabon\">Malabon</a> </td> <td style=\"text-align:right;\">21,148 </td> <td style=\"text-align:right;\">640 </td> <td style=\"text-align:right;\">20,420 </td> <td style=\"text-align:right;\">88 </td> </tr> <tr> <td><a href=\"/wiki/Mandaluyong\" title=\"Mandaluyong\">Mandaluyong</a> </td> <td style=\"text-align:right;\">26,364 </td> <td style=\"text-align:right;\">557 </td> <td style=\"text-align:right;\">25,530 </td> <td style=\"text-align:right;\">277 </td> </tr> <tr> <td><a href=\"/wiki/Manila\" title=\"Manila\">Manila</a> </td> <td style=\"text-align:right;\">89,477 </td> <td style=\"text-align:right;\">1,685 </td> <td style=\"text-align:right;\">87,340 </td> <td style=\"text-align:right;\">452 </td> </tr> <tr> <td><a href=\"/wiki/Marikina\" title=\"Marikina\">Marikina</a> </td> <td style=\"text-align:right;\">25,522 </td> <td style=\"text-align:right;\">624 </td> <td style=\"text-align:right;\">24,572 </td> <td style=\"text-align:right;\">326 </td> </tr> <tr> <td><a href=\"/wiki/Muntinlupa\" title=\"Muntinlupa\">Muntinlupa</a> </td> <td style=\"text-align:right;\">27,381 </td> <td style=\"text-align:right;\">572 </td> <td style=\"text-align:right;\">26,629 </td> <td style=\"text-align:right;\">180 </td> </tr> <tr> <td><a href=\"/wiki/Navotas\" title=\"Navotas\">Navotas</a> </td> <td style=\"text-align:right;\">17,574 </td> <td style=\"text-align:right;\">542 </td> <td style=\"text-align:right;\">16,989 </td> <td style=\"text-align:right;\">43 </td> </tr> <tr> <td><a href=\"/wiki/Para%C3%B1aque\" title=\"Parañaque\">Parañaque</a> </td> <td style=\"text-align:right;\">37,278 </td> <td style=\"text-align:right;\">732 </td> <td style=\"text-align:right;\">37,287 </td> <td style=\"text-align:right;\">259 </td> </tr> <tr> <td><a href=\"/wiki/Pasay\" title=\"Pasay\">Pasay</a> </td> <td style=\"text-align:right;\">21,873 </td> <td style=\"text-align:right;\">544 </td> <td style=\"text-align:right;\">21,227 </td> <td style=\"text-align:right;\">102 </td> </tr> <tr> <td><a href=\"/wiki/Pasig\" title=\"Pasig\">Pasig</a> </td> <td style=\"text-align:right;\">58,657 </td> <td style=\"text-align:right;\">1,422 </td> <td style=\"text-align:right;\">57,015 </td> <td style=\"text-align:right;\">220 </td> </tr> <tr> <td><a href=\"/wiki/Pateros\" title=\"Pateros\">Pateros</a> </td> <td style=\"text-align:right;\">7,668 </td> <td style=\"text-align:right;\">95 </td> <td style=\"text-align:right;\">7,420 </td> <td style=\"text-align:right;\">148 </td> </tr> <tr> <td><a href=\"/wiki/Quezon_City\" title=\"Quezon City\">Quezon City</a> </td> <td style=\"text-align:right;\">176,976 </td> <td style=\"text-align:right;\">1,521 </td> <td style=\"text-align:right;\">172,930 </td> <td style=\"text-align:right;\">2,525 </td> </tr> <tr> <td><a href=\"/wiki/San_Juan,_Metro_Manila\" title=\"San Juan, Metro Manila\">San Juan</a> </td> <td style=\"text-align:right;\">14,997 </td> <td style=\"text-align:right;\">315 </td> <td style=\"text-align:right;\">14,542 </td> <td style=\"text-align:right;\">140 </td> </tr> <tr> <td><a href=\"/wiki/Taguig\" title=\"Taguig\">Taguig</a> </td> <td style=\"text-align:right;\">51,017 </td> <td style=\"text-align:right;\">401 </td> <td style=\"text-align:right;\">50,198 </td> <td style=\"text-align:right;\">418 </td> </tr> <tr> <td><a href=\"/wiki/Valenzuela,_Metro_Manila\" title=\"Valenzuela, Metro Manila\">Valenzuela</a> </td> <td style=\"text-align:right;\">35,376 </td> <td style=\"text-align:right;\">819 </td> <td style=\"text-align:right;\">34,237 </td> <td style=\"text-align:right;\">320 </td> </tr> <tr class=\"sortbottom\"> <th style=\"text-align:left;\">Total </th> <th style=\"text-align:right;\"><img alt=\"Negative increase\" src=\"//upload.wikimedia.org/wikipedia/commons/thumb/5/59/Increase_Negative.svg/11px-Increase_Negative.svg.png\" decoding=\"async\" title=\"Negative increase\" width=\"11\" height=\"11\" srcset=\"//upload.wikimedia.org/wikipedia/commons/thumb/5/59/Increase_Negative.svg/17px-Increase_Negative.svg.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/5/59/Increase_Negative.svg/22px-Increase_Negative.svg.png 2x\" data-file-width=\"300\" data-file-height=\"300\"> 742,058 </th> <th style=\"text-align:right;\"><img alt=\"Negative increase\" src=\"//upload.wikimedia.org/wikipedia/commons/thumb/5/59/Increase_Negative.svg/11px-Increase_Negative.svg.png\" decoding=\"async\" title=\"Negative increase\" width=\"11\" height=\"11\" srcset=\"//upload.wikimedia.org/wikipedia/commons/thumb/5/59/Increase_Negative.svg/17px-Increase_Negative.svg.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/5/59/Increase_Negative.svg/22px-Increase_Negative.svg.png 2x\" data-file-width=\"300\" data-file-height=\"300\"> 13,546 </th> <th style=\"text-align:right;\"><img alt=\"Increase\" src=\"//upload.wikimedia.org/wikipedia/commons/thumb/b/b0/Increase2.svg/11px-Increase2.svg.png\" decoding=\"async\" title=\"Increase\" width=\"11\" height=\"11\" srcset=\"//upload.wikimedia.org/wikipedia/commons/thumb/b/b0/Increase2.svg/17px-Increase2.svg.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/b/b0/Increase2.svg/22px-Increase2.svg.png 2x\" data-file-width=\"300\" data-file-height=\"300\"> 723,058 </th> <th style=\"text-align:right;\"><img alt=\"Positive decrease\" src=\"//upload.wikimedia.org/wikipedia/commons/thumb/9/92/Decrease_Positive.svg/11px-Decrease_Positive.svg.png\" decoding=\"async\" title=\"Positive decrease\" width=\"11\" height=\"11\" srcset=\"//upload.wikimedia.org/wikipedia/commons/thumb/9/92/Decrease_Positive.svg/17px-Decrease_Positive.svg.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/9/92/Decrease_Positive.svg/22px-Decrease_Positive.svg.png 2x\" data-file-width=\"300\" data-file-height=\"300\"> 6,449 </th> </tr> </tbody></table>";
        Document doc2 = Jsoup.parse(html);

        Elements body = doc2.select("table.wikitable.sortable");

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

        cFrame("Metro Manila",
                totalList[1],
                totalList[2],
                totalList[3],
                totalList[4],
                cityList,
                covidCases,
                totalList
        );
    }
}
