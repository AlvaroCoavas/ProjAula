import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class ComidasApp extends javax.swing.JFrame {
    
    private final ArrayList<Comida> listaComidas = new ArrayList<>();

    public ComidasApp() {
        initComponents();
    }
    
    // Definir la estructura de datos para las comidas
    class Comida {
        private String nombre;
        private ArrayList<String> ingredientes = new ArrayList<>();
        
        public Comida(String nombre) {
            this.nombre = nombre;
        }
        
        public String getNombre() {
            return nombre;
        }
        
        public ArrayList<String> getIngredientes() {
            return ingredientes;
        }
    }
    
    // Agregar una comida a la lista
    private void agregarComida(String nombre) {
        Comida comida = new Comida(nombre);
        listaComidas.add(comida);
    }

    // Agregar ingredientes a una comida
    private void agregarIngredientes(String nombre, String ingrediente) {
        for (Comida comida : listaComidas) {
            if (comida.getNombre().equals(nombre)) {
                comida.getIngredientes().add(ingrediente);
                break;
            }
        }
    }
    
    // Actualizar la tabla con los datos de comidas e ingredientes
    private void actualizarTabla() {
        DefaultListModel model = new DefaultListModel();
        for (Comida comida : listaComidas) {
            model.addElement(comida.getNombre() + ": " + comida.getIngredientes());
        }
        listaComidasJList.setModel(model);
    }

    private void initComponents() {
        

        btnAgregarComida.addActionListener((java.awt.event.ActionEvent evt) -> {
            String nombreComida = txtComida.getText();
            agregarComida(nombreComida);
            actualizarTabla();
        });

        btnAgregarIngrediente.addActionListener(new java.awt.event.ActionListener() {
            
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String nombreComida = listaComidasJList.getSelectedValue();
                String ingrediente = txtIngrediente.getText();
                if (nombreComida != null) {
                    agregarIngredientes(nombreComida, ingrediente);
                    actualizarTabla();
                }
            }
        });
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new ComidasApp().setVisible(true);
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnAgregarComida;
    private javax.swing.JButton btnAgregarIngrediente;
    private javax.swing.JList<String> listaComidasJList;
    private javax.swing.JTextField txtComida;
    private javax.swing.JTextField txtIngrediente;
    // ... Otros componentes ...
}
