package rmi.app;

import rmi.GLM.*;
import rmi.GPC.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Base_dados {
    public static void main(String[] args) {
        try {

            APIGestorAgente agente =null;
            agente=(APIGestorAgente)
                    Naming.lookup("rmi://localhost:50002/GPC/GA");

            APIGestorMedicamentos medicamentos =null;
            medicamentos = (APIGestorMedicamentos)
                    Naming.lookup("rmi://localhost:50002/GLM/GM");

            APIGestorUtente utente =null;
            utente = (APIGestorUtente)
                    Naming.lookup("rmi://localhost:50002/GPC/GU");

            APIGestorStock stock =null;
            stock = (APIGestorStock)
                    Naming.lookup("rmi://localhost:50002/GLM/GS");

            APIGestorReceitas receitas =null;
            receitas = (APIGestorReceitas)
                    Naming.lookup("rmi://localhost:50002/GPC/GR");

            APIGestorConsultas consultas =null;
            consultas = (APIGestorConsultas)
                    Naming.lookup("rmi://localhost:50002/GPC/GC");



            //Adicionar agentes
            Agente agente1 = agente.addAgente("123456","João Silva", "Médico");
            Agente agente2 = agente.addAgente("764321","Maria Fernandes", "Enfermeira");
            Agente agente3 = agente.addAgente("234672","Carlos Pinto", "Farmacêutico");
            Agente agente4 = agente.addAgente("987654","Ana Wheezy", "Médica");
            Agente agente5 = agente.addAgente("123472","José Pereira", "Enfermeiro");
            Agente agente6 = agente.addAgente("122888","Laura Martins", "Médica");
            Agente agente7 = agente.addAgente("457899","Ricardo Costa", "Farmacêutico");
            Agente agente8 = agente.addAgente("975432","Fernanda Almeida", "Enfermeira");
            Agente agente9 = agente.addAgente("134678","Miguel Rocha", "Médico");
            Agente agente10 = agente.addAgente("956432 ","Patrícia Lima", "Médica");


            //adicionar utentes
            Utente utente1 = utente.create_utente("12345", "João", "Silva", "Masculino", LocalDate.of(1985, 5, 15), "Porto", "999999999", "silva@gmail.com" );
            Utente utente2 = utente.create_utente("23456", "Maria", "Oliveira", "Feminino", LocalDate.of(1990, 3, 25),"Braga", "888888888", "mariaoliv@gmail.com");
            Utente utente3 = utente.create_utente("34567", "Carlos", "Pereira", "Masculino", LocalDate.of(1978, 11, 5), "Coimbra", "777777777", "pereira@gmail.com");
            Utente utente4 = utente.create_utente("45678", "Ana", "Souza", "Feminino", LocalDate.of(2000, 7, 30), "Sesimbra", "666666666", "souzinha@gmail.com");
            Utente utente5 = utente.create_utente("56789", "Ricardo", "Costa", "Masculino", LocalDate.of(1995, 12, 20), "Castelo Branco", "555555555", "costaaaaa@gmail.com");
            Utente utente6 = utente.create_utente("67890", "Laura", "Martins", "Feminino", LocalDate.of(1992, 8, 10), "Algarve", "444444444", "martines@gmail.com");
            Utente utente7 = utente.create_utente("78901", "Fernanda", "Almeida", "Feminino", LocalDate.of(1983, 1, 12), "Porto", "333333333", "almeidinha@gmail.com");
            Utente utente8 = utente.create_utente("89012", "Miguel", "Rocha", "Masculino", LocalDate.of(1972, 2, 28), "Viseu", "222222222", "rocha@gmail.com");
            Utente utente9 = utente.create_utente("90123", "Patrícia", "Lima", "Feminino", LocalDate.of(1988, 10, 8),"Paços de Ferreira", "111111111", "lima@gmail.com");
            Utente utente10 = utente.create_utente("10234", "Juliana", "Fernandes", "Feminino", LocalDate.of(1995, 6, 3), "Trás-dos-Montes", "123456789", "fernandes@gmail.com");


            //adicionar medicamento
            Medicamento medicamento1 = medicamentos.addMedicamento("Paracetamol", "Usado para aliviar a dor e febre");
            Medicamento medicamento2 = medicamentos.addMedicamento("Ibuprofeno", "Anti-inflamatório e analgésico");
            Medicamento medicamento3 = medicamentos.addMedicamento("Amoxicilina", "Antibiótico para infecções bacterianas");
            Medicamento medicamento4 = medicamentos.addMedicamento("Dipirona", "Usado para aliviar a dor e febre");
            Medicamento medicamento5 = medicamentos.addMedicamento("Losartana", "Medicamento para pressão arterial");
            Medicamento medicamento6 = medicamentos.addMedicamento("Cetorolaco", "Anti-inflamatório e analgésico");
            Medicamento medicamento7 = medicamentos.addMedicamento("Azitromicina", "Antibiótico de largo espectro");
            Medicamento medicamento8 = medicamentos.addMedicamento("Omeprazol", "Inibidor da bomba de prótons, usado para azia");
            Medicamento medicamento9 = medicamentos.addMedicamento("Loratadina", "Antihistamínico, usado para alergias");
            Medicamento medicamento10 = medicamentos.addMedicamento("Salbutamol", "Broncodilatador utilizado em crises asmáticas");


            //adicionar consultas
            Consulta consulta1 = consultas.adicionarConsulta(utente1, agente1, "Consulta de rotina");
            utente.setConsulta("12345",consulta1);
            agente.setConsulta("123456",consulta1);

            Consulta consulta2 = consultas.adicionarConsulta(utente2, agente2, "Consulta de enfermagem");
            utente.setConsulta("23456",consulta2);
            agente.setConsulta("764321",consulta2);

            Consulta consulta3 = consultas.adicionarConsulta(utente3, agente3 , "Consulta de farmacologia");
            utente.setConsulta("34567",consulta3);
            agente.setConsulta("234672",consulta3);

            Consulta consulta4 = consultas.adicionarConsulta(utente4, agente4,  "Consulta de rotina");
            utente.setConsulta("45678",consulta4);
            agente.setConsulta("987654",consulta4);

            Consulta consulta5 = consultas.adicionarConsulta(utente5, agente5, "Consulta de urgência");
            utente.setConsulta("56789",consulta5);
            agente.setConsulta("123472",consulta5);

            Consulta consulta6 = consultas.adicionarConsulta(utente6, agente6,  "Consulta de controle");
            utente.setConsulta("67890",consulta6);
            agente.setConsulta("122888",consulta6);

            Consulta consulta7 = consultas.adicionarConsulta(utente7, agente7, "Consulta de medicamentação");
            utente.setConsulta("78901",consulta7);
            agente.setConsulta("457899",consulta7);

            Consulta consulta8 = consultas.adicionarConsulta(utente8, agente8,  "Consulta de enfermagem");
            utente.setConsulta("89012",consulta8);
            agente.setConsulta("975432",consulta1);

            Consulta consulta9 = consultas.adicionarConsulta(utente9, agente9, "Consulta de emergência");
            utente.setConsulta("90123",consulta9);
            agente.setConsulta("134678",consulta1);

            Consulta consulta10 = consultas.adicionarConsulta(utente10, agente10, "Consulta de rotina");
            utente.setConsulta("10234",consulta10);
            agente.setConsulta("956432",consulta1);


            //adiconar receita
            List<Medicamento> medicamentos1 = new ArrayList<Medicamento>();
            medicamentos1.add(medicamento1);
            medicamentos1.add(medicamento2);
            Receita receita1 = receitas.addReceita(utente1, agente1, consulta1, medicamentos1);
            utente.setReceita("12345",receita1);
            agente.setReceita("123456",receita1);
            consultas.adiconarReceita(utente1,agente1,receita1);
            agente.setMedicamento("123456",medicamento1);
            agente.setMedicamento("123456",medicamento2);

            List<Medicamento> medicamentos2 = new ArrayList<Medicamento>();
            medicamentos2.add(medicamento3);
            Receita receita2 = receitas.addReceita(utente2, agente2, consulta2, medicamentos2);
            utente.setReceita("23456",receita2);
            agente.setReceita("764321",receita2);
            consultas.adiconarReceita(utente2,agente2,receita2);
            agente.setMedicamento("764321",medicamento3);

            List<Medicamento> medicamentos3 = new ArrayList<Medicamento>();
            medicamentos3.add(medicamento4);
            medicamentos3.add(medicamento5);
            Receita receita3 = receitas.addReceita(utente3, agente3, consulta3, medicamentos3);
            utente.setReceita("34567",receita3);
            agente.setReceita("234672",receita3);
            consultas.adiconarReceita(utente3,agente3,receita3);
            agente.setMedicamento("234672",medicamento4);
            agente.setMedicamento("234672",medicamento5);

            List<Medicamento> medicamentos4 =new ArrayList<Medicamento>();
            medicamentos4.add(medicamento6);
            Receita receita4 = receitas.addReceita(utente4, agente4, consulta4, medicamentos4);
            utente.setReceita("45678",receita4);
            agente.setReceita("987654",receita4);
            consultas.adiconarReceita(utente4,agente4,receita4);
            agente.setMedicamento("987654",medicamento6);

            List<Medicamento> medicamentos5 = new ArrayList<Medicamento>();
            medicamentos5.add(medicamento7);
            medicamentos5.add(medicamento8);
            Receita receita5 = receitas.addReceita(utente5, agente5, consulta5, medicamentos5);
            utente.setReceita("56789",receita5);
            agente.setReceita("123472",receita5);
            consultas.adiconarReceita(utente5,agente5,receita5);
            agente.setMedicamento("123472",medicamento7);
            agente.setMedicamento("123472",medicamento8);

            List<Medicamento> medicamentos6 = new ArrayList<Medicamento>();
            medicamentos6.add(medicamento9);
            Receita receita6 = receitas.addReceita(utente6, agente6, consulta6, medicamentos6);
            utente.setReceita("67890",receita6);
            agente.setReceita("122888",receita6);
            consultas.adiconarReceita(utente6,agente6,receita6);
            agente.setMedicamento("122888",medicamento9);

            List<Medicamento> medicamentos7 = new ArrayList<Medicamento>();
            medicamentos7.add(medicamento10);
            Receita receita7 = receitas.addReceita(utente7, agente7, consulta7, medicamentos7);
            utente.setReceita("78901",receita7);
            agente.setReceita("457899",receita7);
            consultas.adiconarReceita(utente7,agente7,receita7);
            agente.setMedicamento("457899",medicamento10);


            List<Medicamento> medicamentos8 = new ArrayList<Medicamento>();
            medicamentos8.add(medicamento2);
            medicamentos8.add(medicamento9);
            Receita receita8 = receitas.addReceita(utente8, agente8, consulta8, medicamentos8);
            utente.setReceita("89012",receita8);
            agente.setReceita("975432",receita8);
            consultas.adiconarReceita(utente8,agente8,receita8);
            agente.setMedicamento("975432",medicamento2);
            agente.setMedicamento("975432",medicamento9);

            List<Medicamento> medicamentos9 = new ArrayList<Medicamento>();
            medicamentos9.add(medicamento1);
            medicamentos9.add(medicamento3);
            Receita receita9 = receitas.addReceita(utente9, agente9, consulta9, medicamentos9);
            utente.setReceita("90123",receita9);
            agente.setReceita("134678",receita9);
            consultas.adiconarReceita(utente9,agente9,receita9);
            agente.setMedicamento("134678",medicamento1);
            agente.setMedicamento("134678",medicamento3);

            List<Medicamento> medicamentos10 = new ArrayList<Medicamento>();
            medicamentos10.add(medicamento4);
            medicamentos10.add(medicamento6);
            Receita receita10 = receitas.addReceita(utente10, agente10, consulta10, medicamentos10);
            utente.setReceita("10234",receita10);
            agente.setReceita("956432",receita10);
            consultas.adiconarReceita(utente10,agente10,receita10);
            agente.setMedicamento("956432",medicamento4);
            agente.setMedicamento("956432",medicamento6);

            Stock stock1 = stock.addMedicamento("9f52a8c3-23b1-4f67-9d11-3e4d6a78b4cd", medicamento1, 10, 100, 50,"Bayer");
            Stock stock2 = stock.addMedicamento("d3a87b0d-e7c4-4f1c-8b7d-2c02b8e962aa", medicamento2, 10, 50, 30,"Pfizer");
            Stock stock3 = stock.addMedicamento("ae54f218-1a3d-432c-94fd-88a77e5a1c9d", medicamento3, 10, 40, 20,"Bayer");
            Stock stock4 = stock.addMedicamento("71b2e8f9-fc7d-4d35-b6a1-4f098d09232e", medicamento4, 10, 80, 60,"Pfizer");
            Stock stock5 = stock.addMedicamento("b897d812-4e57-4b96-9422-94c93e0a7df6", medicamento5, 10, 30, 15,"Bayer");
            Stock stock6 = stock.addMedicamento("c84f4af5-8b21-4e99-b02e-4f8b7d5a68ce", medicamento6, 10, 100, 90,"Pfizer");
            Stock stock7 = stock.addMedicamento("60a2f3a4-9074-46b1-8728-7a4c62cdb356", medicamento7, 10, 60, 40,"Sanofi");
            Stock stock8 = stock.addMedicamento("f4e2b6d8-5c89-4d18-a37b-6fa4790eb7f4", medicamento8, 10, 50, 35,"Sanofi");
            Stock stock9 = stock.addMedicamento("ab74d6e2-3cbf-4b87-b1e3-8ca76d2f5ec3", medicamento9, 10, 60, 45,"Sanofi");
            Stock stock10 = stock.addMedicamento("e2184f09-7a6d-4e18-9c34-8b5d0e4f67ae", medicamento10, 10, 70, 55,"Bayer");



            System.out.println("Base de dados adicionada.");

        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
