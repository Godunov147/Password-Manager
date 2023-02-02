package org.example.model;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PasswordTableModel implements TableModel {

    Set<TableModelListener> listeners = new HashSet<>();

    List<Password> passwords;

    public PasswordTableModel(List<Password> passwords) {
        this.passwords = passwords;
    }

    @Override
    public int getRowCount() {
        return passwords.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String column = null;
        if (columnIndex == 0){
            column = "URL";
        }
        if (columnIndex == 1){
            column = "Пароль";
        }
        if (columnIndex == 2){
            column = "E-mail";
        }
        return column;

    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Password password = passwords.get(rowIndex);
        String column = null;
        if (columnIndex == 0){
            column = password.getUrl();
        }
        if (columnIndex == 1){
            column = password.getPassword();
        }
        if (columnIndex == 2){
            column = password.getEmail();
        }
        return column;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void removeTableModelListener(TableModelListener listener) {
        this.listeners.remove(listener);
    }
}
