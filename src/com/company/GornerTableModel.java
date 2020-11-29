package com.company;

import javax.swing.table.AbstractTableModel;
@SuppressWarnings("serial")
public class GornerTableModel extends AbstractTableModel {
    private Double[] coefficients;
    private Double from;
    private Double to;
    private Double step;
    private double result;

    public GornerTableModel(Double from, Double to, Double step, Double[] coefficients) {

        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficients = coefficients;
    }
    public Double getFrom() {
        return from;
    }
    public Double getTo() {
        return to;
    }
    public Double getStep() {
        return step;
    }
    public int getColumnCount() {

        return 4;
    }
    public int getRowCount() {

        return new Double(Math.ceil((to-from)/step)).intValue()+1;
    }
    public Object getValueAt(int row, int col) {

        double x = from + step * row;
        switch (col) {
            case 0:
                return x;
            case 1: {
                result = 0.0;
                for (int i = 0; i < coefficients.length; i++) {
                    result += Math.pow(x, coefficients.length - 1 - i) * coefficients[i];
                }
                return result;
            }
            case 2:{
                return result > 0;
            }
            case 3:{
                if ((int)result % 2 != 0){
                    return "pain";
                } else{
                    return "happiness";
                }
            }
            default: {
                return 0;
            }

        }
    }
    public String getColumnName(int col) {
        switch (col) {
            case 3:
                return "life is";
            case 0:
                return "Значение X";
            case 2:
                return "Значение больше 0?";
            default:
                return "Значение многочлена";
        }
    }
    public Class<?> getColumnClass(int col) {
// И в 1-ом и во 2-ом столбце находятся значения типа Double

        if (col == 0 || col == 1){
            return Double.class;
        }
        else if(col == 3){
            return String.class;
        }
        else{
            return Boolean.class;
        }

    }
}
