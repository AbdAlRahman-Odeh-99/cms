/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consumer_test;

import javax.swing.JPanel;

/**
 *
 * @author abdal
 */
public class UserPanel extends JPanel{
    
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel addressResult;
    private javax.swing.JPanel carInfoPanel;
    private javax.swing.JLabel carInformationLabel;
    private javax.swing.JLabel carStatsLable;
    private javax.swing.JPanel carStatsPanel;
    private javax.swing.JLabel carStatsTime;
    private javax.swing.JLabel coolantLabel;
    private javax.swing.JLabel coolantResult;
    private javax.swing.JLabel emailLable;
    private javax.swing.JLabel emailResult;
    private javax.swing.JLabel fuelLabel;
    private javax.swing.JLabel fuelResult;
    private javax.swing.JLabel lastCarStatsLabel;
    private javax.swing.JLabel latLabel;
    private javax.swing.JLabel latResult;
    private javax.swing.JLabel locationTimeLabel;
    private javax.swing.JLabel locationTimeResult;
    private javax.swing.JLabel longLabel;
    private javax.swing.JLabel longResult;
    private javax.swing.JLabel makeLabel;
    private javax.swing.JLabel makeResult;
    private javax.swing.JLabel modelLabel;
    private javax.swing.JLabel modelResult;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel nameResult;
    private javax.swing.JLabel oilLabel;
    private javax.swing.JLabel oilResult;
    private javax.swing.JLabel phoneLable;
    private javax.swing.JLabel phoneResult;
    private javax.swing.JLabel rpmLabel;
    private javax.swing.JLabel rpmResult;
    private javax.swing.JLabel speedLable;
    private javax.swing.JLabel speedResult;
    private javax.swing.JPanel userInfoPanel;
    private javax.swing.JLabel userInformationLabel;
    private javax.swing.JLabel useridLabel;
    private javax.swing.JLabel useridResult;
    private javax.swing.JLabel yearLabel;
    private javax.swing.JLabel yearResult;
    
    UserPanel()
    {
        userInfoPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        emailLable = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        userInformationLabel = new javax.swing.JLabel();
        nameResult = new javax.swing.JLabel();
        emailResult = new javax.swing.JLabel();
        addressResult = new javax.swing.JLabel();
        phoneLable = new javax.swing.JLabel();
        phoneResult = new javax.swing.JLabel();
        useridResult = new javax.swing.JLabel();
        useridLabel = new javax.swing.JLabel();
        carStatsPanel = new javax.swing.JPanel();
        carStatsLable = new javax.swing.JLabel();
        speedLable = new javax.swing.JLabel();
        coolantLabel = new javax.swing.JLabel();
        fuelLabel = new javax.swing.JLabel();
        rpmLabel = new javax.swing.JLabel();
        oilLabel = new javax.swing.JLabel();
        latLabel = new javax.swing.JLabel();
        longLabel = new javax.swing.JLabel();
        fuelResult = new javax.swing.JLabel();
        coolantResult = new javax.swing.JLabel();
        rpmResult = new javax.swing.JLabel();
        oilResult = new javax.swing.JLabel();
        latResult = new javax.swing.JLabel();
        longResult = new javax.swing.JLabel();
        speedResult = new javax.swing.JLabel();
        lastCarStatsLabel = new javax.swing.JLabel();
        carStatsTime = new javax.swing.JLabel();
        locationTimeLabel = new javax.swing.JLabel();
        locationTimeResult = new javax.swing.JLabel();
        carInfoPanel = new javax.swing.JPanel();
        makeLabel = new javax.swing.JLabel();
        modelLabel = new javax.swing.JLabel();
        yearLabel = new javax.swing.JLabel();
        carInformationLabel = new javax.swing.JLabel();
        makeResult = new javax.swing.JLabel();
        modelResult = new javax.swing.JLabel();
        yearResult = new javax.swing.JLabel();

        this.setBackground(new java.awt.Color(204, 204, 204));

        userInfoPanel.setBackground(new java.awt.Color(204, 204, 0));
        userInfoPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        userInfoPanel.setAutoscrolls(true);

        nameLabel.setForeground(new java.awt.Color(0, 0, 0));
        nameLabel.setText("Name:");

        emailLable.setForeground(new java.awt.Color(0, 0, 0));
        emailLable.setText("Email:");

        addressLabel.setForeground(new java.awt.Color(0, 0, 0));
        addressLabel.setText("Address:");
        addressLabel.setName(""); // NOI18N

        userInformationLabel.setForeground(new java.awt.Color(0, 0, 0));
        userInformationLabel.setText("User Information");

        nameResult.setForeground(new java.awt.Color(0, 0, 0));
        nameResult.setText("-");

        emailResult.setForeground(new java.awt.Color(0, 0, 0));
        emailResult.setText("-");

        addressResult.setForeground(new java.awt.Color(0, 0, 0));
        addressResult.setText("-");

        phoneLable.setForeground(new java.awt.Color(0, 0, 0));
        phoneLable.setText("Phone:");

        phoneResult.setForeground(new java.awt.Color(0, 0, 0));
        phoneResult.setText("-");

        useridResult.setForeground(new java.awt.Color(0, 0, 0));
        useridResult.setText("-");

        useridLabel.setForeground(new java.awt.Color(0, 0, 0));
        useridLabel.setText("UserID:");

        javax.swing.GroupLayout userInfoPanelLayout = new javax.swing.GroupLayout(userInfoPanel);
        userInfoPanel.setLayout(userInfoPanelLayout);
        userInfoPanelLayout.setHorizontalGroup(
            userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userInfoPanelLayout.createSequentialGroup()
                        .addComponent(userInformationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                        .addGap(25, 25, 25))
                    .addGroup(userInfoPanelLayout.createSequentialGroup()
                        .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(useridLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(phoneLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(emailLable, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(53, 53, 53)
                        .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(userInfoPanelLayout.createSequentialGroup()
                                .addComponent(emailResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(138, 138, 138))
                            .addGroup(userInfoPanelLayout.createSequentialGroup()
                                .addComponent(nameResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(100, 100, 100))
                            .addComponent(addressResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(userInfoPanelLayout.createSequentialGroup()
                                .addComponent(phoneResult, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(useridResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        userInfoPanelLayout.setVerticalGroup(
            userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userInformationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(useridLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                    .addComponent(useridResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                    .addComponent(nameResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2)
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLable, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(emailResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneLable, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(phoneResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(addressResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8))
        );

        nameLabel.getAccessibleContext().setAccessibleName("nameLabel");
        emailLable.getAccessibleContext().setAccessibleName("emailLabel");
        addressLabel.getAccessibleContext().setAccessibleName("addressLabel");
        nameResult.getAccessibleContext().setAccessibleName("nameResult");
        emailResult.getAccessibleContext().setAccessibleName("emailResult");
        addressResult.getAccessibleContext().setAccessibleName("addressResult");
        phoneLable.getAccessibleContext().setAccessibleName("phoneLabel");
        phoneResult.getAccessibleContext().setAccessibleName("phoneResult");
        useridResult.getAccessibleContext().setAccessibleName("useridResult");
        useridLabel.getAccessibleContext().setAccessibleName("useridLabel");

        carStatsPanel.setBackground(new java.awt.Color(51, 153, 255));
        carStatsPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        carStatsPanel.setAutoscrolls(true);

        carStatsLable.setForeground(new java.awt.Color(0, 0, 0));
        carStatsLable.setText("Car Stats");

        speedLable.setForeground(new java.awt.Color(0, 0, 0));
        speedLable.setText("Speed:");

        coolantLabel.setForeground(new java.awt.Color(0, 0, 0));
        coolantLabel.setText("Coolant Temperature:");

        fuelLabel.setForeground(new java.awt.Color(0, 0, 0));
        fuelLabel.setText("Fuel Level:");

        rpmLabel.setForeground(new java.awt.Color(0, 0, 0));
        rpmLabel.setText("RPM:");

        oilLabel.setForeground(new java.awt.Color(0, 0, 0));
        oilLabel.setText("Oil Temperature:");

        latLabel.setForeground(new java.awt.Color(0, 0, 0));
        latLabel.setText("Lat:");

        longLabel.setForeground(new java.awt.Color(0, 0, 0));
        longLabel.setText("Long:");

        fuelResult.setForeground(new java.awt.Color(0, 0, 0));
        fuelResult.setText("-");

        coolantResult.setForeground(new java.awt.Color(0, 0, 0));
        coolantResult.setText("-");

        rpmResult.setForeground(new java.awt.Color(0, 0, 0));
        rpmResult.setText("-");

        oilResult.setForeground(new java.awt.Color(0, 0, 0));
        oilResult.setText("-");

        latResult.setForeground(new java.awt.Color(0, 0, 0));
        latResult.setText("-");

        longResult.setForeground(new java.awt.Color(0, 0, 0));
        longResult.setText("-");

        speedResult.setForeground(new java.awt.Color(0, 0, 0));
        speedResult.setText("-");

        lastCarStatsLabel.setForeground(new java.awt.Color(0, 0, 0));
        lastCarStatsLabel.setText("Time of last Car Stats:");

        carStatsTime.setForeground(new java.awt.Color(0, 0, 0));
        carStatsTime.setText("-");

        locationTimeLabel.setForeground(new java.awt.Color(0, 0, 0));
        locationTimeLabel.setText("Time of last Location:");

        locationTimeResult.setForeground(new java.awt.Color(0, 0, 0));
        locationTimeResult.setText("-");

        javax.swing.GroupLayout carStatsPanelLayout = new javax.swing.GroupLayout(carStatsPanel);
        carStatsPanel.setLayout(carStatsPanelLayout);
        carStatsPanelLayout.setHorizontalGroup(
            carStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carStatsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(carStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(carStatsLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, carStatsPanelLayout.createSequentialGroup()
                        .addGroup(carStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(speedLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fuelLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(carStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(speedResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fuelResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(carStatsPanelLayout.createSequentialGroup()
                        .addComponent(coolantLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(coolantResult, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                        .addGap(12, 12, 12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(carStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(carStatsPanelLayout.createSequentialGroup()
                        .addComponent(oilLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(oilResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(75, 75, 75))
                    .addGroup(carStatsPanelLayout.createSequentialGroup()
                        .addComponent(rpmLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rpmResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(118, 118, 118))
                    .addGroup(carStatsPanelLayout.createSequentialGroup()
                        .addGroup(carStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lastCarStatsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(carStatsPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(carStatsTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(carStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, carStatsPanelLayout.createSequentialGroup()
                        .addGroup(carStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(locationTimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(locationTimeResult, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(117, 117, 117))
                    .addGroup(carStatsPanelLayout.createSequentialGroup()
                        .addGroup(carStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(latLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(longLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(carStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(carStatsPanelLayout.createSequentialGroup()
                                .addComponent(longResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(126, 126, 126))
                            .addGroup(carStatsPanelLayout.createSequentialGroup()
                                .addComponent(latResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(155, 155, 155))))))
        );
        carStatsPanelLayout.setVerticalGroup(
            carStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carStatsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(carStatsLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(carStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(carStatsPanelLayout.createSequentialGroup()
                        .addGroup(carStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(latLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(latResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(89, 89, 89))
                    .addGroup(carStatsPanelLayout.createSequentialGroup()
                        .addGroup(carStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(speedLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rpmLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rpmResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(speedResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(carStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fuelLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(oilLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fuelResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(oilResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(longLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(longResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(carStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(coolantResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lastCarStatsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(locationTimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(coolantLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(2, 2, 2)
                        .addGroup(carStatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(carStatsTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(locationTimeResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        carStatsLable.getAccessibleContext().setAccessibleName("carStatsLable");
        speedLable.getAccessibleContext().setAccessibleName("speedLable");
        coolantLabel.getAccessibleContext().setAccessibleName("coolantLabel");
        fuelLabel.getAccessibleContext().setAccessibleName("fuelLabel");
        rpmLabel.getAccessibleContext().setAccessibleName("rpmLabel");
        oilLabel.getAccessibleContext().setAccessibleName("oilLabel");
        latLabel.getAccessibleContext().setAccessibleName("latLabel");
        longLabel.getAccessibleContext().setAccessibleName("longLabel");
        fuelResult.getAccessibleContext().setAccessibleName("fuelResult");
        coolantResult.getAccessibleContext().setAccessibleName("coolantResult");
        rpmResult.getAccessibleContext().setAccessibleName("rpmResult");
        oilResult.getAccessibleContext().setAccessibleName("oilResult");
        latResult.getAccessibleContext().setAccessibleName("latResult");
        longResult.getAccessibleContext().setAccessibleName("longResult");
        speedResult.getAccessibleContext().setAccessibleName("speedResult");
        lastCarStatsLabel.getAccessibleContext().setAccessibleName("lastCarStatsLabel");
        carStatsTime.getAccessibleContext().setAccessibleName("carStatsTime");
        locationTimeLabel.getAccessibleContext().setAccessibleName("locationTimeLabel");
        locationTimeResult.getAccessibleContext().setAccessibleName("-locationTimeResult");

        carInfoPanel.setBackground(new java.awt.Color(204, 204, 0));
        carInfoPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        carInfoPanel.setAutoscrolls(true);

        makeLabel.setForeground(new java.awt.Color(0, 0, 0));
        makeLabel.setText("Make:");

        modelLabel.setForeground(new java.awt.Color(0, 0, 0));
        modelLabel.setText("Model:");

        yearLabel.setForeground(new java.awt.Color(0, 0, 0));
        yearLabel.setText("Year:");
        yearLabel.setName(""); // NOI18N

        carInformationLabel.setForeground(new java.awt.Color(0, 0, 0));
        carInformationLabel.setText("Car Information");

        makeResult.setForeground(new java.awt.Color(0, 0, 0));
        makeResult.setText("-");

        modelResult.setForeground(new java.awt.Color(0, 0, 0));
        modelResult.setText("-");

        yearResult.setForeground(new java.awt.Color(0, 0, 0));
        yearResult.setText("-");

        javax.swing.GroupLayout carInfoPanelLayout = new javax.swing.GroupLayout(carInfoPanel);
        carInfoPanel.setLayout(carInfoPanelLayout);
        carInfoPanelLayout.setHorizontalGroup(
            carInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(carInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(carInformationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(carInfoPanelLayout.createSequentialGroup()
                        .addGroup(carInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(carInfoPanelLayout.createSequentialGroup()
                                .addGroup(carInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(modelLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(makeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(carInfoPanelLayout.createSequentialGroup()
                                .addComponent(yearLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(49, 49, 49)))
                        .addGroup(carInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(carInfoPanelLayout.createSequentialGroup()
                                .addComponent(yearResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, carInfoPanelLayout.createSequentialGroup()
                                .addComponent(modelResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(67, 67, 67))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, carInfoPanelLayout.createSequentialGroup()
                                .addComponent(makeResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(53, 53, 53)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        carInfoPanelLayout.setVerticalGroup(
            carInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(carInformationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addGroup(carInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(makeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(makeResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(carInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modelLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(modelResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(carInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yearLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(yearResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );

        makeLabel.getAccessibleContext().setAccessibleName("makeLabel");
        modelLabel.getAccessibleContext().setAccessibleName("modelLabel");
        yearLabel.getAccessibleContext().setAccessibleName("yearLabel");
        carInformationLabel.getAccessibleContext().setAccessibleName("carInformationLabel");
        makeResult.getAccessibleContext().setAccessibleName("makeResult");
        modelResult.getAccessibleContext().setAccessibleName("modelResult");
        yearResult.getAccessibleContext().setAccessibleName("yearResult");

        javax.swing.GroupLayout userPanelLayout = new javax.swing.GroupLayout(this);
        this.setLayout(userPanelLayout);
        userPanelLayout.setHorizontalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(carStatsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(userPanelLayout.createSequentialGroup()
                        .addComponent(userInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(carInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        userPanelLayout.setVerticalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(carInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carStatsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        carStatsPanel.getAccessibleContext().setAccessibleName("carStatsPanel");

        this.getAccessibleContext().setAccessibleName("userPanel");

    }

    public void updateUserInformation(String[] userInformation)
    {
        this.useridResult.setText(userInformation[0]);
        this.nameResult.setText(userInformation[1]);
        this.emailResult.setText(userInformation[2]);
        this.phoneResult.setText(userInformation[3]);
        this.addressResult.setText(userInformation[4]);
    }
    
    public void updateCarInformation(String[] carInformation)
    {
        this.makeResult.setText(carInformation[0]);
        this.modelResult.setText(carInformation[1]);
        this.yearResult.setText(carInformation[2]);
    }
    
    public void updatelocationInformation(String[] locationInformation)
    {
        this.latResult.setText(locationInformation[0]);
        this.longResult.setText(locationInformation[1]);
        this.locationTimeResult.setText(locationInformation[2]);
    }
    
    public void updateCarStats (String[] carStats)
    {
        this.speedResult.setText(carStats[0]);
        this.coolantResult.setText(carStats[1]);
        this.oilResult.setText(carStats[2]);
        this.rpmResult.setText(carStats[3]);
        this.fuelResult.setText(carStats[4]);
        this.carStatsTime.setText(carStats[5]);
    }
    
}

