package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;

public class tablaAdaptativa {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de tabla adaptable");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear una tabla con datos de ejemplo
        String[] columnNames = {"Nombre", "Edad"};
        Object[][] data = {
                {"Juan", 30},
                {"María", 25},
                {"Carlos", 40},
                {"Ana", 35}
        };
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);

        // Ajustar el ancho de las columnas según el contenido
        adjustColumnWidths(table);

        // Agregar la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);

        // Configurar el layout del JFrame
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);

        // Ajustar el tamaño del JFrame automáticamente al tamaño del contenido
        frame.pack();
        frame.setVisible(true);
    }

    private static void adjustColumnWidths(JTable table) {
        for (int column = 0; column < table.getColumnCount(); column++) {
            TableColumn tableColumn = table.getColumnModel().getColumn(column);
            int preferredWidth = 0;
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
                Component c = table.prepareRenderer(cellRenderer, row, column);
                int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
                preferredWidth = Math.max(preferredWidth, width);
            }
            tableColumn.setPreferredWidth(preferredWidth + 10); // Ajuste opcional para espacio adicional
        }
    }
}
