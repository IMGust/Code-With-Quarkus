package model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat (shape = JsonFormat.Shape.OBJECT)
public enum TipoMotor {

        MOTOR_CAMINHAO("Caminhão", 1),
        MOTOR_MOTO("Moto", 2),
        MOTOR_Esportivo("GT", 3);

        private final String NOME;
        private final int ID;

        TipoMotor(String nome, int id){
            this.NOME = nome;
            this.ID = id;
        }

        public String getNOME() {
        return NOME;
        }

        public int getID() {
        return ID;
        }

        public static TipoMotor valueof(Integer id){
            if(id == null) return null;

            for(TipoMotor m: TipoMotor.values()){
                if(m.getID() == id){
                        return m;
                }
            }

            return null;
        }

}
