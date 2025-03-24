import PetCare.Pet;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class PetCareManagement 
		extends JFrame 	{

    private DefaultListModel<String> petListModel;
    private JList<String> petList;
    private JTextField petNameField, petAgeField, petTypeField, petBreedField, petPriceField;
    private JButton addButton, sortButton, treatButton;
    private ArrayList<Pet> pets;

    public PetCareManagement()
    {
        setTitle("Pet Care Management");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        pets = new ArrayList<>();
        
        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        petNameField = new JTextField();
        petAgeField = new JTextField();
        petTypeField = new JTextField();
        petBreedField = new JTextField();
        petPriceField = new JTextField();
        
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(petNameField);
        inputPanel.add(new JLabel("Age:"));
        inputPanel.add(petAgeField);
        inputPanel.add(new JLabel("Type(Dog, Cat, Bird):"));
        inputPanel.add(petTypeField);
        inputPanel.add(new JLabel("Breed:"));
        inputPanel.add(petBreedField);
        inputPanel.add(new JLabel("Price:"));
        inputPanel.add(petPriceField);

        addButton = new JButton("Add Pet");
        sortButton = new JButton("Sort by Price");
        treatButton = new JButton("Start Treatment");
        addButton.addActionListener(e -> addPet());
        sortButton.addActionListener(e -> sortPets());
        treatButton.addActionListener(e -> startTreatment());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(sortButton);
        buttonPanel.add(treatButton);

        petListModel = new DefaultListModel<>();
        petList = new JList<>(petListModel);
        JScrollPane scrollPane = new JScrollPane(petList);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    void addPet()
    {
        try
	{
            String name = petNameField.getText().trim();
            int age = Integer.parseInt(petAgeField.getText().trim());
            String type = petTypeField.getText().trim();
            String breed = petBreedField.getText().trim();
            int price = Integer.parseInt(petPriceField.getText().trim());
            
            Pet newPet = new Pet(price, age, name, type, breed);
            pets.add(newPet);
            petListModel.addElement(newPet.toString());
        } 
	catch (Exception e) { JOptionPane.showMessageDialog(this, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE); }
    }

    void sortPets()
    {
        pets.sort(Comparator.comparingInt(Pet::getpetprice));
        petListModel.clear();
        for (Pet pet : pets) { petListModel.addElement(pet.toString()); }
    }

    void startTreatment()
    {
        if (pets.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "No pets available for treatment", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        new Thread(() -> {
            for (Pet pet : pets) {
                try {
                    Thread.sleep(1000);
                    System.out.println("Treating " + pet.getPetName());
                }
                catch (InterruptedException e) { e.printStackTrace(); }
            }
            JOptionPane.showMessageDialog(this, "Pets Treatment Completed", "Success", JOptionPane.INFORMATION_MESSAGE);
        }).start();
    }

    public static void main(String[] args) { SwingUtilities.invokeLater(() -> new PetCareManagement().setVisible(true)); }

}