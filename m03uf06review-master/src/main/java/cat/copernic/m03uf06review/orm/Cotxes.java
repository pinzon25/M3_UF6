/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.m03uf06review.orm;

import java.sql.Date;

/**
 *
 * @author riki
 */
public class Cotxes {

    private String Model;
    private int Potencia_motor;
    private float Acceleracio_motor;
    private boolean Origen_europeu;
    private Date Data_fabricacio;

    public Cotxes() { /*Inicialment no feia falta, no obstant es necessari pel correcte funcionament d'obtencio de dades de la base de dades mitjancant hibernate.*/
        Model = "";
        Potencia_motor = 0;
        Acceleracio_motor = 0;
        Origen_europeu = false;
        Data_fabricacio = null;
    }

    public Cotxes(String Model, int Potencia_motor, float Acceleracio_motor, boolean Origen_europeu, Date Data_fabricacio) {
        this.Model = Model;
        this.Potencia_motor = Potencia_motor;
        this.Acceleracio_motor = Acceleracio_motor;
        this.Origen_europeu = Origen_europeu;
        this.Data_fabricacio = Data_fabricacio;
    }

    /**
     * @return the Model
     */
    public String getModel() {
        return Model;
    }

    /**
     * @param Model the Model to set
     */
    public void setModel(String Model) {
        this.Model = Model;
    }

    /**
     * @return the Potencia_motor
     */
    public int getPotencia_motor() {
        return Potencia_motor;
    }

    /**
     * @param Potencia_motor the Potencia_motor to set
     */
    public void setPotencia_motor(int Potencia_motor) {
        this.Potencia_motor = Potencia_motor;
    }

    /**
     * @return the Acceleracio_motor
     */
    public float getAcceleracio_motor() {
        return Acceleracio_motor;
    }

    /**
     * @param Acceleracio_motor the Acceleracio_motor to set
     */
    public void setAcceleracio_motor(float Acceleracio_motor) {
        this.Acceleracio_motor = Acceleracio_motor;
    }

    /**
     * @return the Origen_europeu
     */
    public boolean isOrigen_europeu() {
        return Origen_europeu;
    }

    /**
     * @param Origen_europeu the Origen_europeu to set
     */
    public void setOrigen_europeu(boolean Origen_europeu) {
        this.Origen_europeu = Origen_europeu;
    }

    /**
     * @return the Data_fabricacio
     */
    public Date getData_fabricacio() {
        return Data_fabricacio;
    }

    /**
     * @param Data_fabricacio the Data_fabricacio to set
     */
    public void setData_fabricacio(Date Data_fabricacio) {
        this.Data_fabricacio = Data_fabricacio;
    }

    @Override
    public String toString() {
        return "Cotxes{" + "Model=" + Model + ", Potencia_motor=" + Potencia_motor + ", Acceleracio_motor=" + Acceleracio_motor + ", Origen_europeu=" + Origen_europeu + ", Data_fabricacio=" + Data_fabricacio + '}';
    }

}
