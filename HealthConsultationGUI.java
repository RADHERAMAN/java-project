package book_java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HealthConsultationGUI {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Online Health Consultation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null); // Center the window

        // Create the panel for patient information
        JPanel patientPanel = new JPanel();
        patientPanel.setLayout(new BoxLayout(patientPanel, BoxLayout.Y_AXIS));
        patientPanel.add(new JLabel("Patient Name:"));
        JTextField patientNameField = new JTextField();
        patientNameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        patientPanel.add(patientNameField);

        patientPanel.add(new JLabel("Patient Age:"));
        JTextField patientAgeField = new JTextField();
        patientAgeField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        patientPanel.add(patientAgeField);

        patientPanel.add(new JLabel("Patient Contact Number:"));
        JTextField patientContactField = new JTextField();
        patientContactField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        patientPanel.add(patientContactField);

        patientPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space

        // Create the panel for doctor information
        JPanel doctorPanel = new JPanel();
        doctorPanel.setLayout(new BoxLayout(doctorPanel, BoxLayout.Y_AXIS));
        doctorPanel.add(new JLabel("Doctor Name:"));
        JTextField doctorNameField = new JTextField();
        doctorNameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        doctorPanel.add(doctorNameField);

        doctorPanel.add(new JLabel("Doctor Specialty:"));
        JTextField doctorSpecialtyField = new JTextField();
        doctorSpecialtyField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        doctorPanel.add(doctorSpecialtyField);

        doctorPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space

        // Create the panel for consultation details
        JPanel consultationPanel = new JPanel();
        consultationPanel.setLayout(new BoxLayout(consultationPanel, BoxLayout.Y_AXIS));
        consultationPanel.add(new JLabel("Consultation Date:"));
        JTextField consultationDateField = new JTextField();
        consultationDateField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        consultationPanel.add(consultationDateField);

        consultationPanel.add(new JLabel("Consultation Time:"));
        JTextField consultationTimeField = new JTextField();
        consultationTimeField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        consultationPanel.add(consultationTimeField);

        consultationPanel.add(new JLabel("Consultation Details:"));
        JTextArea consultationDetailsArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(consultationDetailsArea);
        consultationPanel.add(scrollPane);

        // Create the Save button
        JButton saveButton = new JButton("Save Details");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveDetails(patientNameField.getText(),
                        patientAgeField.getText(),
                        patientContactField.getText(),
                        doctorNameField.getText(),
                        doctorSpecialtyField.getText(),
                        consultationDateField.getText(),
                        consultationTimeField.getText(),
                        consultationDetailsArea.getText());
            }
        });

        // Add the button to the consultation panel
        consultationPanel.add(saveButton);

        // Add the panels to the frame
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.getContentPane().add(patientPanel);
        frame.getContentPane().add(doctorPanel);
        frame.getContentPane().add(consultationPanel);

        // Make the frame visible
        frame.setVisible(true);
    }

    private static void saveDetails(String patientName, String patientAge, String patientContact,
                                    String doctorName, String doctorSpecialty, String consultationDate,
                                    String consultationTime, String consultationDetails) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("consultation_details.txt", true))) {
            writer.write("Patient Name: " + patientName);
            writer.newLine();
            writer.write("Patient Age: " + patientAge);
            writer.newLine();
            writer.write("Patient Contact Number: " + patientContact);
            writer.newLine();
            writer.write("Doctor Name: " + doctorName);
            writer.newLine();
            writer.write("Doctor Specialty: " + doctorSpecialty);
            writer.newLine();
            writer.write("Consultation Date: " + consultationDate);
            writer.newLine();
            writer.write("Consultation Time: " + consultationTime);
            writer.newLine();
            writer.write("Consultation Details: " + consultationDetails);
            writer.newLine();
            writer.write("------------------------------------------------");
            writer.newLine();
            JOptionPane.showMessageDialog(null, "Details saved successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving details: " + e.getMessage());
        }
    }
}
