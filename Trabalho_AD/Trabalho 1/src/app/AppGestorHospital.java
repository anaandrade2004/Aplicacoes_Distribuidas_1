package rmi.app;

import rmi.GLM.*;
import rmi.GPC.*;

import javax.xml.transform.Source;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

public class AppGestorHospital {

    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {




            while (true) {
                System.out.println("""
                        Bem-vindo ao Gestor Hospitalar
                        (1) Utente
                        (2) Gestor de Stock (Farmacêutico)
                        (3) Médico/Enfermeiro
                        (4) Administrador
                        (0) Sair
                        Que opção deseja a utilizar:
                        """);
                Scanner sc = new Scanner(System.in);
                System.out.println("Opção da escolha- ");
                String i = sc.nextLine();
                if (i.equals("1")) {
                    utente();//Done perfeito lindo <3 POKER
                } else if (i.equals("2")) {
                    farma();
                } else if (i.equals("3")) {
                    agente();
                } else if (i.equals("4")) {
                    admin();
                } else if (i.equals("0")) {
                    System.out.println(("Obrigado pela sua escolha"));
                    break;
                } else {
                    System.out.println("Não existe essa opção");
                }
            }
    }




    public static void admin() throws RemoteException, MalformedURLException,NotBoundException {
        int option = -2;

        Scanner sc = new Scanner(System.in);
        APIGestorAgente agente = null;
        APIGestorMedicamentos medicamentos = null;
        APIGestorUtente utente = null;
        APIGestorStock stock = null;
        APIGestorReceitas receitas = null;
        APIGestorConsultas consultas = null;

        agente = (APIGestorAgente)
                Naming.lookup("rmi://localhost:50002/GPC/GA");

        medicamentos = (APIGestorMedicamentos)
                Naming.lookup("rmi://localhost:50002/GLM/GM");

        utente = (APIGestorUtente)
                Naming.lookup("rmi://localhost:50002/GPC/GU");

        stock = (APIGestorStock)
                Naming.lookup("rmi://localhost:50002/GLM/GS");

        receitas = (APIGestorReceitas)
                Naming.lookup("rmi://localhost:50002/GPC/GR");

        consultas = (APIGestorConsultas)
                Naming.lookup("rmi://localhost:50002/GPC/GC");
        System.out.println("Diga a password do admin");
        String pass = sc.nextLine();
        if (pass.equals("1234567890")) {

            while (true) {
                System.out.println("""
                        Bem-vindo à página de admin
                            (1) Listar Utentes
                            (2) Listar Médicos/Farmacêuticos/Enfermeiros
                            (3) Stock Existente
                            (4) Adiconar novo utente
                            (5) Adiconar novo agente
                            (6) Adicionar consulta
                            (7) Adicionar novo medicamento
                            (8) Adicionar fornecedor a um medicamento
                            (9) Estatísticas
                        
                            (0) Voltar atrás
                        """);
                System.out.println("Selecione uma das opções acima:");
                option = sc.nextInt();
                if (option == 1) {
                    List<Utente> utentes = utente.getUtentes();
                    for (Utente u : utentes) {
                        System.out.println(u.toString() + "\n");
                    }
                } else if (option == 2) {
                    Map<String, Agente> agentes = agente.getAgentes();
                    for (Agente a : agentes.values()) {
                        System.out.println(a.toString() + "\n");
                        break;
                    }
                } else if (option == 3) {
                    List<Stock> stocks = stock.getAllStock();
                    for (Stock s : stocks) {
                        System.out.println(s.toString() + "\n");
                    }
                } else if (option == 4) {
                    System.out.println("Insira dos dados do utente.");
                    System.out.println("A qualquer momento se quiser parar basta fazer 'stop' na linha de comandos");
                    sc.nextLine();
                    System.out.println("Número de utente:");
                    String id_utente = sc.nextLine();
                    if (id_utente.equals("stop")) {
                        break;
                    } else {
                        System.out.println("Nome:");
                        String nome_utente = sc.nextLine();
                        if (nome_utente.equals("stop")) {
                            break;
                        } else {
                            System.out.println("Apelido:");
                            String apelido_utente = sc.nextLine();
                            if (apelido_utente.equals("stop")) {
                                break;
                            } else {
                                System.out.println("Género: (Feminino / Masculino)");
                                String genero_utente = sc.nextLine();
                                if (genero_utente.equals("stop")) {
                                    break;
                                } else if (genero_utente.equals("Feminino") || genero_utente.equals("Masculino")) {
                                    System.out.println("Data de Nascimento: (dd/MM/yyyy)");
                                    String dataNascimento_utente = sc.nextLine();
                                    if (dataNascimento_utente.equals("stop")) {
                                        break;
                                    } else {
                                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                        LocalDate dataNascimento = LocalDate.parse(dataNascimento_utente, formatter);
                                        System.out.println("Morada:");
                                        String morada_utente = sc.nextLine();
                                        if (morada_utente.equals("stop")) {
                                            break;
                                        } else {
                                            System.out.println("Telemóvel:");
                                            String telemovel_utente = sc.nextLine();
                                            if (telemovel_utente.equals("stop")) {
                                                break;
                                            } else {

                                                System.out.println("Email:");
                                                String email_utente = sc.nextLine();
                                                if (email_utente.equals("stop")) {
                                                    break;
                                                } else {
                                                    System.out.println("Creating utente with parameters:");
                                                    System.out.println("ID: " + id_utente);
                                                    System.out.println("Nome: " + nome_utente);
                                                    System.out.println("Apelido: " + apelido_utente);
                                                    System.out.println("Genero: " + genero_utente);
                                                    System.out.println("Data Nascimento: " + dataNascimento);
                                                    System.out.println("Morada: " + morada_utente);
                                                    System.out.println("Telemovel: " + telemovel_utente);
                                                    System.out.println("Email: " + email_utente);

                                                    Utente novo_utente = utente.create_utente(id_utente, nome_utente, apelido_utente,
                                                            genero_utente, dataNascimento, morada_utente,
                                                            telemovel_utente, email_utente);
                                                    System.out.println("Utente created successfully: " + (novo_utente != null));
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("Essa opção não existe");
                                }
                            }
                        }

                    }


                } else if (option == 5) {
                    System.out.println("Para adiconar um novo agente, preencha os dados abaixo.");
                    System.out.println("id do agente");
                    String id_agente = sc.nextLine();
                    System.out.println("Nome do agente:");
                    String nome_agente = sc.nextLine();
                    System.out.println("Cargo do agente:");
                    String cargo_agente = sc.nextLine();

                    System.out.println("Creating utente with parameters:");
                    System.out.println("Nome: " + nome_agente);
                    System.out.println("Email: " + cargo_agente);
                    Agente novo_agente = agente.addAgente(id_agente, nome_agente, cargo_agente);
                    System.out.println("Agente created successfully: " + (novo_agente != null));

                } else if (option == 6) {
                    System.out.println("Insira o número de utente que deseja associar a esta consulta.");
                    String id_utente = sc.nextLine();
                    if (utente.getUtente(id_utente) != null) {
                        System.out.println("Utente associado com sucesso.");
                        Utente info_utente_selected = utente.getUtente(id_utente);
                        System.out.println("Adicone o agente responsável pela consulta.Id:");
                        String id_agente = sc.nextLine();

                        Agente info_agente_selected = agente.getAgentePorId(id_agente);
                        if (info_agente_selected != null) {
                            System.out.println("Objetivo da consulta.");
                            String descricao_nova_consulta = sc.nextLine();
                            Consulta cons = consultas.adicionarConsulta(info_utente_selected, info_agente_selected, descricao_nova_consulta);
                            System.out.println("Deseja associar uma receita a esta consulta? (yes/no)");
                            String res = sc.nextLine();


                            while (res.equals("yes")) {
                                List<Medicamento> lista_medicamentos = new ArrayList<>();
                                List<Receita> lista_receitas = new ArrayList<>();
                                System.out.println("Os medicamentos que existem são:");
                                System.out.println(medicamentos.listarMedicamentosPorNome());
                                while (true) {
                                    System.out.println("Escreva o nome do medicamento que deseja. Quando acabar, escreva 'stop'.");
                                    String choose_id_medic = sc.nextLine();
                                    Medicamento medicamento_a_adicionar = medicamentos.getMedicamentoporNome(choose_id_medic);
                                    lista_medicamentos.add(medicamento_a_adicionar);
                                    agente.setMedicamento(id_agente, medicamento_a_adicionar);
                                    if (choose_id_medic.equals("stop")) {
                                        break;
                                    }
                                }
                                Receita receita_a_adiconar = new Receita(info_utente_selected, info_agente_selected, cons, lista_medicamentos);
                                consultas.adiconarReceita(info_utente_selected, info_agente_selected, receita_a_adiconar);

                                agente.setReceita(id_agente, receita_a_adiconar);


                                System.out.println("Deseja associar mais uma receita a esta consulta? (yes/no)");
                                res = sc.nextLine();

                            }
                            agente.setConsulta(id_agente, cons);
                            utente.setConsulta(id_utente, cons);

                            System.out.println("Feito");

                            System.out.println("Consulta adicionada com sucesso.");


                        }

                    } else {
                        System.out.println("O utente não existe.");
                    }


                } else if (option == 7) {
                    while (true) {
                        System.out.println("A qualquer momento se quiser parar basta fazer 'stop' na linha de comandos");
                        System.out.println("Introduza o nome do medicamento.");
                        String nome_create_medicamento = sc.nextLine();


                        if (nome_create_medicamento.equals("stop")) {
                            break;
                        } else {
                            System.out.println("Introduza a descrição do medicamento.");
                            String desc_create_medicamento = sc.nextLine();
                            if (desc_create_medicamento.equals("stop")) {
                                break;
                            } else {
                                Medicamento add_medicamento = medicamentos.addMedicamento(nome_create_medicamento, desc_create_medicamento);

                                System.out.println("Medicamento introduzido com sucesso.");
                                System.out.println(" Medicamento adicionado:\n" + add_medicamento);

                                int s_min_generico = 10;
                                int s_max_generico = 50;
                                System.out.println("Quantidade que vai adicionar:");
                                int quantidade_a_adicionar = sc.nextInt();
                                sc.nextLine();
                                if (quantidade_a_adicionar > s_max_generico) {
                                    System.out.println("Stock a adicionar excede o Armazenamento máximo de 50");
                                    break;
                                }
                                System.out.println("Fornecedor deste medicamento:");
                                String fornecedor = sc.nextLine();
                                Stock novo_medicamento_stock = stock.addMedicamento(add_medicamento.getID(), add_medicamento, s_min_generico, s_max_generico, quantidade_a_adicionar,fornecedor);
                                System.out.println("Stock foi adicionado" + novo_medicamento_stock);
                            }
                        }


                    }
                } else if (option == 8) {
                    while (true) {
                        sc.nextLine();
                        System.out.println(medicamentos.listarMedicamentosPorNome());
                        System.out.println("A que medicamento quer adicionar o stock");
                        String med = sc.nextLine();
                        Stock st = stock.getStockPorNome(med);
                        if (stock.getStockPorNome(med) != null) {
                            System.out.println("Nome do fornecedor a adicionar");
                            String fornecedor = sc.nextLine();
                            st.setFornecedor(fornecedor);
                            System.out.println("Fornecedor adicionado:\n" + st);

                        }
                        System.out.println("Deseja adiconar mais fornecedores se não escreva 'no'");
                        String res = sc.nextLine();
                        if (res.equals("no")) {
                            break;
                        }

                    }

                } else if (option == 9) {
                    while (true) {
                        sc.nextLine();
                        System.out.println("""
                                Escolha uma opção:
                                (1) Número de utentes
                                (2) Número de agentes
                                (3) Medicamento com mais stock
                                (4) Utente(s) com mais consultas
    
                                (0) Voltar atrás  
                                """);
                        option = sc.nextInt();
                        if (option == 1) {
                            List<Utente> u= utente.getUtentes();
                            System.out.println("Temos "+u.size()+" Utentes.");

                        } else if (option == 2) {
                            List<Agente> a= agente.listagente();
                            System.out.println("Temos "+a.size()+" Agentes.");

                        }else if (option == 3) {
                            List<Stock> ls = stock.getAllStock();
                            int maior = 0;
                            Medicamento med = null;
                            for (Stock s : ls) {
                                if (s.getS_total()>maior) {
                                    maior = s.getS_total();
                                    med = s.getMedicamento();
                                }

                            }
                            assert med != null;
                            System.out.println("O medicamento com maior stock tem "+maior+"e é o medicamento é" +med.getNome());


                        }else if (option == 4) {
                            int maior=0;
                            List<Utente> ut=new ArrayList<>();
                            List<Utente> u= utente.getUtentes();
                            for (Utente s : u) {
                                List<Consulta> c = s.getConsultas();
                                if (c.size()>maior) {
                                    maior = c.size();
                                    ut.add(s);

                                }

                            }

                            System.out.println("Os utentes com mais consultas vieram "+ maior+" e são;\n "+ut);

                        }else if (option == 0) {
                            break;
                        }
                    }

                } else if (option == 0) {
                    break;

                }else {
                    System.out.println("Não existe essa opção");
                }
            }
        }else{
            System.out.println("Não tem acesso a este campo");
        }
    }


            public static void agente () throws RemoteException, MalformedURLException, NotBoundException {
                APIGestorAgente agente = null;
                APIGestorMedicamentos medicamentos = null;
                APIGestorUtente utente = null;
                APIGestorReceitas receitas = null;
                APIGestorConsultas consultas = null;

                agente = (APIGestorAgente)
                        Naming.lookup("rmi://localhost:50002/GPC/GA");

                medicamentos = (APIGestorMedicamentos)
                        Naming.lookup("rmi://localhost:50002/GLM/GM");

                utente = (APIGestorUtente)
                        Naming.lookup("rmi://localhost:50002/GPC/GU");

                receitas = (APIGestorReceitas)
                        Naming.lookup("rmi://localhost:50002/GPC/GR");

                consultas = (APIGestorConsultas)
                        Naming.lookup("rmi://localhost:50002/GPC/GC");
                int option = -2;
                Scanner sc = new Scanner(System.in);
                System.out.println("Introduza o seu id de acesso");
                String ag = sc.nextLine();
                if (agente.getAgentePorId(ag).getCargo().equals("Médico") || agente.getAgentePorId(ag).getCargo().equals("Médica") || agente.getAgentePorId(ag).getCargo().equals("Enfermeira") || agente.getAgentePorId(ag).getCargo().equals("Enfermeira")) {
                    while (true) {
                        System.out.println("\n");
                        System.out.println("""
                                Bem-vindo à página de Agente
                                Que opção deseja a utilizar:
                                (1) Informações existentes de todos os utentes
                                (2) Procurar/Adicionar um Utente pelo seu número de utente
                                (3) Procurar pelo histórico de consultas de um determinado utente
                                (4) Procurar todas as minhas consultas
                                (5) Adicionar consulta
                                
                                (0) Sair
                                """);


                        System.out.println("Selecione uma opção acima:");
                        option = sc.nextInt();
                        sc.nextLine();
                        if (option == 1) {
                            List<Utente> utentes = utente.getUtentes();
                            for (Utente u : utentes) {
                                System.out.println(u.toString() + "\n");
                            }
                        } else if (option == 2) {
                            System.out.println("Insira o número de identificação do utente a pesquisar");
                            String num_u = sc.nextLine();
                            if (utente.getUtente(num_u) != null) {
                                Utente utente_info = utente.getUtente(num_u);
                                System.out.println(utente_info + "\n");
                            } else {
                                System.out.println("O utente não se encontra registado.");
                                System.out.println("Deseja inserir utente?");
                                System.out.println("yes / no");
                                String res = sc.nextLine();
                                if (res.equals("yes")) {
                                    System.out.println("Insira dos dados do utente.");
                                    System.out.println("A qualquer momento se quiser parar basta fazer 'stop' na linha de comandos");
                                    System.out.println("Número de utente:");
                                    String id_utente = sc.nextLine();
                                    if (id_utente.equals("stop")) {
                                        break;
                                    } else {
                                        System.out.println("Nome:");
                                        String nome_utente = sc.nextLine();
                                        if (nome_utente.equals("stop")) {
                                            break;
                                        } else {
                                            System.out.println("Apelido:");
                                            String apelido_utente = sc.nextLine();
                                            if (apelido_utente.equals("stop")) {
                                                break;
                                            } else {
                                                System.out.println("Género: (Feminino / Masculino)");
                                                String genero_utente = sc.nextLine();
                                                if (genero_utente.equals("stop")) {
                                                    break;
                                                } else if (genero_utente.equals("Feminino") || genero_utente.equals("Masculino")) {
                                                    System.out.println("Data de Nascimento: (dd/MM/yyyy)");
                                                    String dataNascimento_utente = sc.nextLine();
                                                    if (dataNascimento_utente.equals("stop")) {
                                                        break;
                                                    } else {
                                                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                                        LocalDate dataNascimento = LocalDate.parse(dataNascimento_utente, formatter);
                                                        System.out.println("Morada:");
                                                        String morada_utente = sc.nextLine();
                                                        if (morada_utente.equals("stop")) {
                                                            break;
                                                        } else {
                                                            System.out.println("Telemóvel:");
                                                            String telemovel_utente = sc.nextLine();
                                                            if (telemovel_utente.equals("stop")) {
                                                                break;
                                                            } else {

                                                                System.out.println("Email:");
                                                                String email_utente = sc.nextLine();
                                                                if (email_utente.equals("stop")) {
                                                                    break;
                                                                } else {
                                                                    System.out.println("Creating utente with parameters:");
                                                                    System.out.println("ID: " + id_utente);
                                                                    System.out.println("Nome: " + nome_utente);
                                                                    System.out.println("Apelido: " + apelido_utente);
                                                                    System.out.println("Genero: " + genero_utente);
                                                                    System.out.println("Data Nascimento: " + dataNascimento);
                                                                    System.out.println("Morada: " + morada_utente);
                                                                    System.out.println("Telemovel: " + telemovel_utente);
                                                                    System.out.println("Email: " + email_utente);

                                                                    Utente novo_utente = utente.create_utente(id_utente, nome_utente, apelido_utente,
                                                                            genero_utente, dataNascimento, morada_utente,
                                                                            telemovel_utente, email_utente);
                                                                    System.out.println("Utente created successfully: " + (novo_utente != null));
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    System.out.println("Essa opção não existe");
                                                }
                                            }
                                        }

                                    }

                                } else if (res.equals("no")) {
                                    System.out.println("O utente não existe e não foi introduzido");
                                } else {
                                    System.out.println("Essa opção não existe");
                                }
                            }
                        } else if (option == 3) {
                            System.out.println("Insira o número de utente a pesquisar");
                            String num_u = sc.nextLine();
                            if (utente.getUtente(num_u) != null) {
                                List<Consulta> consultas_utente = consultas.listarConsultasPorUtente(utente.getUtente(num_u));
                                System.out.println(consultas_utente + "\n");
                            } else {
                                System.out.println("Utente não se encontra registado logo não apresenta histórico de consultas.");
                            }
                        } else if (option == 4) {
                            List<Consulta> con = agente.getAgentePorId(ag).getConsulta();
                            System.out.println("As suas Consultas:\n" + con);


                        } else if (option == 5) {
                            System.out.println("Insira o número de utente que deseja associar a esta consulta.");
                            String id_utente = sc.nextLine();
                            if (utente.getUtente(id_utente) != null) {
                                System.out.println("Utente associado com sucesso.");
                                Utente info_utente_selected = utente.getUtente(id_utente);
                                Agente info_agente_selected = agente.getAgentePorId(ag);
                                if (info_agente_selected != null) {
                                    System.out.println("Objetivo da consulta.");
                                    String descricao_nova_consulta = sc.nextLine();
                                    Consulta cons= consultas.adicionarConsulta(info_utente_selected,info_agente_selected,descricao_nova_consulta);
                                    System.out.println("Deseja associar uma receita a esta consulta? (yes/no)");
                                    String res = sc.nextLine();



                                    while (res.equals("yes")) {
                                        List<Medicamento> lista_medicamentos = new ArrayList<>();
                                        List<Receita> lista_receitas = new ArrayList<>();
                                        System.out.println("Os medicamentos que existem são:");
                                        System.out.println(medicamentos.listarMedicamentosPorNome());
                                        while (true){
                                            System.out.println("Escreva o nome do medicamento que deseja. Quando acabar, escreva 'stop'.");
                                            String choose_id_medic = sc.nextLine();
                                            Medicamento medicamento_a_adicionar = medicamentos.getMedicamentoporNome(choose_id_medic);
                                            lista_medicamentos.add(medicamento_a_adicionar);
                                            agente.setMedicamento(ag,medicamento_a_adicionar);
                                            if (choose_id_medic.equals("stop")) {
                                                break;
                                            }
                                        }
                                        Receita receita_a_adiconar = new Receita(info_utente_selected,info_agente_selected,cons,lista_medicamentos);
                                        consultas.adiconarReceita(info_utente_selected, info_agente_selected, receita_a_adiconar);

                                        agente.setReceita(ag,receita_a_adiconar);


                                        System.out.println("Deseja associar mais uma receita a esta consulta? (yes/no)");
                                        res = sc.nextLine();

                                    }
                                    agente.setConsulta(ag,cons);
                                    utente.setConsulta(id_utente,cons);

                                    System.out.println("Feito");

                                    System.out.println("Consulta adicionada com sucesso.");


                                }
                            }

                        } else if (option == 0) {
                            break;
                        } else {
                            System.out.println("Essa opção não existe");
                        }


                    }
                } else {
                    System.out.println("Não tem acesso a estas informações");

                }
            }

            public static void farma () throws MalformedURLException, NotBoundException, RemoteException {
                int option = -2;
                Scanner sc = new Scanner(System.in);
                APIGestorAgente agente = null;
                agente = (APIGestorAgente)
                        Naming.lookup("rmi://localhost:50002/GPC/GA");

                APIGestorMedicamentos medicamentos = null;
                medicamentos = (APIGestorMedicamentos)
                        Naming.lookup("rmi://localhost:50002/GLM/GM");


                APIGestorStock stock = null;
                stock = (APIGestorStock)
                        Naming.lookup("rmi://localhost:50002/GLM/GS");

                System.out.println("Introduza o seu id de acesso:");
                String n_farma = sc.nextLine();

                if (agente.getAgentePorId(n_farma).getCargo().equals("Farmacêutico")) {

                    while (option != 0) {
                        System.out.println("""
                                Bem-vindo à página de Farmacêutico
                                Que opção deseja a utilizar:
                                (1) Stock existente
                                (2) Adicionar medicamento novo
                                (3) Adicionar Stock de um medicamento
                                (4) Venda de medicamentos \n
                                (0) Sair
                                """);

                        System.out.println("Selecione uma das opções acima:");
                        option = sc.nextInt();
                        sc.nextLine();
                        System.out.println("\n");
                        if (option == 1) {
                            List<Stock> stocks = stock.getAllStock();
                            for (Stock s : stocks) {
                                System.out.println(s.toString() + "\n");
                            }
                        } else if (option == 2) {
                            while (true) {
                                System.out.println("A qualquer momento se quiser parar basta fazer 'stop' na linha de comandos");
                                System.out.println("Introduza o nome do medicamento.");
                                String nome_create_medicamento = sc.nextLine();


                                if (nome_create_medicamento.equals("stop")) {
                                    break;
                                } else {
                                    System.out.println("Introduza a descrição do medicamento.");
                                    String desc_create_medicamento = sc.nextLine();
                                    if (desc_create_medicamento.equals("stop")) {
                                        break;
                                    } else {
                                        Medicamento add_medicamento = medicamentos.addMedicamento(nome_create_medicamento, desc_create_medicamento);

                                        System.out.println("Medicamento introduzido com sucesso.");
                                        System.out.println(" Medicamento adicionado:\n" + add_medicamento);

                                        int s_min_generico = 10;
                                        int s_max_generico = 50;
                                        System.out.println("Quantidade que vai adicionar:");
                                        int quantidade_a_adicionar = sc.nextInt();
                                        sc.nextLine();
                                        if (quantidade_a_adicionar > s_max_generico) {
                                            System.out.println("Stock a adicionar excede o Armazenamento máximo de 50");
                                            break;
                                        }
                                        System.out.println("Nome do fornecedor");
                                        String fornecedor = sc.nextLine();
                                        Stock novo_medicamento_stock = stock.addMedicamento(add_medicamento.getID(), add_medicamento, s_min_generico, s_max_generico, quantidade_a_adicionar,fornecedor);
                                        System.out.println("Stock foi adicionado" +novo_medicamento_stock);
                                    }
                                }

                            }

                        } else if (option == 3){
                            System.out.println(medicamentos.listarMedicamentosPorNome());
                            System.out.println("Qual o medicamento que deseja adicionar ao stock?");
                            String nome_medic = sc.nextLine();
                            for (Medicamento m : medicamentos.listarMedicamentos()){
                                if (m.getNome().equals(nome_medic)){
                                    System.out.println("Qual o fornecedor deste medicamento");
                                    String fornecedor = sc.nextLine();
                                    if(stock.getStockPorNome(nome_medic).getFornecedor().contains(fornecedor)) {
                                        Stock stock_existente = stock.getStockPorNome(nome_medic);
                                        System.out.println("Stock existente: " + stock_existente);
                                        int stock_available_para_compra = stock_existente.getS_total();
                                        System.out.println("Stock available: " + stock_available_para_compra);
                                        System.out.println("Introduza a quantidade a receber no stock.");
                                        int quantidade_a_receber = sc.nextInt();
                                        int stock_temporario = quantidade_a_receber + stock_available_para_compra;
                                        int armazenamento_maximo = stock_existente.getS_max();
                                        System.out.println("Stock temporario: " + stock_temporario);
                                        if (stock_temporario > armazenamento_maximo) {
                                            System.out.println("Armazenamento insuficiente");
                                        } else if (stock_temporario < armazenamento_maximo) {
                                            System.out.println("Existe armazenamento sufiecente para receber abastecimento de stock.");
                                            Stock stock_atualizado = stock.addToStock(stock_existente.getId(), quantidade_a_receber);
                                            System.out.println(stock_atualizado);
                                        }
                                    }else {
                                        System.out.println("Fornecedor não existente");
                                    }
                                }
                            }
                        } else if (option == 4){
                            System.out.println(medicamentos.listarMedicamentosPorNome());
                            System.out.println("Que medicamento deseja vender? Introduza o nome do respetivo.");

                            String nome_medicamento_a_procurar = sc.nextLine();
                            for (Medicamento m : medicamentos.listarMedicamentos()){
                                if (m.getNome().equals(nome_medicamento_a_procurar)) {

                                    Stock stock_existente = stock.getStockPorNome(nome_medicamento_a_procurar);
                                    Medicamento get_medicamento = medicamentos.getMedicamentoporNome(nome_medicamento_a_procurar);
                                    System.out.println("medicamento:\n" + get_medicamento);
                                    String get_id_medic_a_comprar = get_medicamento.getID();
                                    System.out.println("Informações sobre medicamento procurado:\n " + stock_existente);
                                    System.out.println("Quantas unidade deseja comprar");
                                    int quantidade_a_comprar = sc.nextInt();

                                    if (quantidade_a_comprar >( stock_existente.getS_total()-stock_existente.getS_min())) {
                                        String id_stock_med_a_comprar = stock_existente.getId();
                                        Stock quant = stock.useFromStock(id_stock_med_a_comprar, quantidade_a_comprar);
                                        System.out.println("Quantidade: " + quant);
                                        System.out.println("Compra efetuada com sucesso");
                                        System.out.println("ALERTA:Stock em baixo");
                                        break;

                                    } else if (quantidade_a_comprar > stock_existente.getS_total()) {
                                        System.out.println("ALERTA:não existe stock suficiente para efeutar a compra");
                                        break;

                                    }else{
                                            String id_stock_med_a_comprar = stock_existente.getId();
                                            Stock quant = stock.useFromStock(id_stock_med_a_comprar, quantidade_a_comprar);
                                            System.out.println("Quantidade: " + quant);
                                            System.out.println("Compra efetuada com sucesso");
                                            break;
                                        }
                                }

                            }
                            System.out.println("Não existe medicamentos com esse nome:");

                        }
                    }

                }else {
                    System.out.println("Não tem acesso a estas informações");
                }




            }
            public static void utente () throws MalformedURLException, NotBoundException, RemoteException {
                int option = -2;
                APIGestorUtente utente = null;
                utente = (APIGestorUtente)
                        Naming.lookup("rmi://localhost:50002/GPC/GU");

                Scanner scu = new Scanner(System.in);
                System.out.println("Qual é o seu número de utente:");
                String num_u = scu.nextLine();
                    if (utente.getUtente(num_u) != null) {
                        while (true) {
                            System.out.println("""
                                    Bem-vindo à página de utente
                                    Que opção deseja a utilizar:
                                    (1) Ver todas as minhas informações
                                    (0) Sair
                                    """);
                            Scanner sc1 = new Scanner(System.in);
                            System.out.println("Selecione uma das opções acima:");
                            option = sc1.nextInt();
                            sc1.nextLine();
                            System.out.println("\n");
                            if (option == 1) {
                                Utente utente_info = utente.getUtente(num_u);
                                System.out.println(utente_info + "\n");

                            } else if (option == 0) {
                                break;

                            }else {
                                System.out.println("Não existe essa opção");
                            }
                        }
                    } else {
                        System.out.println("Este número de utente não se existe." + "\n");
                    }


            }
        }
