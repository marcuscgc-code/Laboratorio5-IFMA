package org.main;

import org.main.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Cria o EntityManagerFactory usando a configuração do persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("carro_frete");
        // Cria o EntityManager
        EntityManager em = emf.createEntityManager();

        try {
            // Inicia a transação
            em.getTransaction().begin();

            // Instanciando entidades


            ItemFrete it1 = new ItemFrete();
            ItemFrete it2 = new ItemFrete();
            ItemFrete it3 = new ItemFrete();
            CategoriaFrete caf1 = new CategoriaFrete();
            CategoriaFrete caf2 = new CategoriaFrete();
            CategoriaFrete caf3 = new CategoriaFrete();




            Frete fr1 = new Frete();
            Frete fr2 = new Frete();
            Frete fr3 = new Frete();

            // Configurando Filiais
            Filial f1 = new Filial();
            Filial f2 = new Filial();
            Filial f3 = new Filial();
            f1.setNome("São Bernado");
            f1.setTelefone("16589712");
            f1.setEndereco("Rua Harvard");
            f2.setNome("Pirapora");
            f2.setTelefone("78955482");
            f2.setEndereco("Rua Santa Teresa");
            f3.setNome("Rio de Janeiro");
            f3.setTelefone("55788681");
            f3.setEndereco("Bairro Favela");

            // Configurando Funcionarios
            Funcionario fun1 = new Funcionario();
            Funcionario fun2 = new Funcionario();
            Funcionario fun3 = new Funcionario();
            fun1.setCpf("06339842605");
            fun1.setNome("Batman");
            fun1.setMatricula("AVB45");
            fun1.setEmail("batman@gmail.com");
            fun1.setFilial(f1);
            fun2.setCpf("217491283");
            fun2.setNome("Robin");
            fun2.setMatricula("AVB981");
            fun2.setEmail("robin@gmail.com");
            fun2.setFilial(f2);
            fun3.setCpf("45889856");
            fun3.setNome("Superman");
            fun3.setMatricula("AVB112");
            fun3.setEmail("crypton@gmail.com");
            fun3.setFilial(f3);
            //relacioanando
            f1.getFuncionarios().add(fun1);
            f2.getFuncionarios().add(fun2);
            f3.getFuncionarios().add(fun3);

            // Configurando Clientes
            Cliente cl1 = new Cliente();
            Cliente cl2 = new Cliente();
            Cliente cl3 = new Cliente();
            cl1.setNome("Dr.Destino");
            cl1.setCpf("666666666");
            cl1.setEmail("destino@gmail.com");
            cl1.setAtivo(true);

            cl2.setNome("DR.Estranho");
            cl2.setCpf("999999999");
            cl2.setEmail("estranheza@gmail.com");
            cl2.setAtivo(true);

            cl3.setNome("Homem-Aranha");
            cl3.setCpf("444444444");
            cl3.setEmail("spiderman@gmail.com");
            cl3.setAtivo(true);

            // Configurando Dependentes
            Dependente de1 = new Dependente();
            Dependente de2 = new Dependente();
            Dependente de3 = new Dependente();
            de1.setNome("Wolverine");
            de1.setDataNascimento(LocalDate.of(1992, 6, 1));
            de1.setFuncionario(fun1);

            de2.setNome("Deadpoll");
            de2.setDataNascimento(LocalDate.of(1998, 10, 11));
            de2.setFuncionario(fun2);

            de3.setNome("Fanático");
            de3.setDataNascimento(LocalDate.of(1989, 8, 12));
            de3.setFuncionario(fun3);

            // Configurando Tipos de Veículos
            TipoVeiculo tv1 = new TipoVeiculo();
            TipoVeiculo tv2 = new TipoVeiculo();
            TipoVeiculo tv3 = new TipoVeiculo();
            tv1.setDescricao("Caminhão leve");
            tv1.setPesoMaximo(BigDecimal.valueOf(8000.00));
            tv2.setDescricao("Van de correspondencia");
            tv2.setPesoMaximo(BigDecimal.valueOf(2000.00));
            tv3.setDescricao("Caminhão de Carga");
            tv3.setPesoMaximo(BigDecimal.valueOf(20000.00));



            // Configurando Veículos
            Veiculo v1 = new Veiculo();
            Veiculo v2 = new Veiculo();
            Veiculo v3 = new Veiculo();
            v1.setNumeroPlaca("AVG1458");
            v2.setNumeroPlaca("PRT7878");
            v3.setNumeroPlaca("GAV9642");
            v1.setFilial(f1);
            v2.setFilial(f2);
            v3.setFilial(f3);
            v1.setTipoVeiculo(tv1);
            v2.setTipoVeiculo(tv2);
            v3.setTipoVeiculo(tv3);

            // Configurando Cidades
            Cidade cid1 = new Cidade();
            Cidade cid2 = new Cidade();
            Cidade cid3 = new Cidade();
            cid1.setUf("BA");
            cid1.setEstado("Bahia");
            cid1.setNome("Salvador");
            cid2.setUf("SP");
            cid2.setEstado("São Paulo");
            cid2.setNome("São Paulo");
            cid3.setUf("CE");
            cid3.setEstado("Ceará");
            cid3.setNome("Fortaleza");

            // Configurando Distâncias
            Distancia di1 = new Distancia();
            Distancia di2 = new Distancia();
            Distancia di3 = new Distancia();
            di1.setCidadeOrigem(cid1);
            di1.setCidadeDestino(cid2);
            di1.setQuilometros(200);

            di2.setCidadeOrigem(cid1);
            di2.setCidadeDestino(cid3);
            di2.setQuilometros(600);

            di3.setCidadeOrigem(cid2);
            di3.setCidadeDestino(cid3);
            di3.setQuilometros(500);

            // Configurando Categorias de Frete
            caf1.setNome("Normal");
            caf1.setDescricao("Normal, 0% acrescimo.");
            caf1.setPercentualAdicional(0.0F);

            caf2.setNome("Express");
            caf2.setDescricao("Express, 10% acrescimo.");
            caf2.setPercentualAdicional(10.0F);

            caf3.setNome("Sedex");
            caf3.setDescricao("Sedex, 30% acrescimo");
            caf3.setPercentualAdicional(30.0F);

            // Configurando Itens de Frete
            it1.setDescricao("Bicicleta");
            it1.setPeso(10.0f);

            it2.setDescricao("Playstation 5");
            it2.setPeso(20.0f);

            it3.setDescricao("BatCarro");
            it3.setPeso(30.0f);

            // Configurando Fretes
            fr1.setCategoriaFrete(caf1);
            fr1.setCidadeOrigem(cid1);
            fr1.setCidadeDestino(cid2);
            fr1.setVeiculo(v1);
            fr1.setCliente(cl1);
            fr1.setNumeroNotaFiscal(1456);
            fr1.setValorKmRodado(BigDecimal.valueOf(1.00));
            it1.setFrete(fr1);

            fr2.setCategoriaFrete(caf2);
            fr2.setCidadeOrigem(cid2);
            fr2.setCidadeDestino(cid3);
            fr2.setVeiculo(v2);
            fr2.setCliente(cl2);
            fr2.setNumeroNotaFiscal(1045);
            fr2.setValorKmRodado(BigDecimal.valueOf(1.50));
            it2.setFrete(fr2);

            fr3.setCategoriaFrete(caf3);
            fr3.setCidadeOrigem(cid1);
            fr3.setCidadeDestino(cid3);
            fr3.setVeiculo(v3);
            fr3.setCliente(cl3);
            fr3.setNumeroNotaFiscal(1503);
            fr3.setValorKmRodado(BigDecimal.valueOf(2.00));
            it3.setFrete(fr3);

            // Persistindo entidades
            em.persist(f1);
            em.persist(f2);
            em.persist(f3);
            em.persist(fun1);
            em.persist(fun2);
            em.persist(fun3);
            em.persist(cl1);
            em.persist(cl2);
            em.persist(cl3);
            em.persist(di1);
            em.persist(di2);
            em.persist(di3);
            em.persist(tv1);
            em.persist(tv2);
            em.persist(tv3);
            em.persist(v1);
            em.persist(v2);
            em.persist(v3);
            em.persist(caf1);
            em.persist(caf2);
            em.persist(caf3);
            em.persist(it1);
            em.persist(it2);
            em.persist(it3);
            em.persist(fr1);
            em.persist(fr2);
            em.persist(fr3);

            // Commit da transação
            em.getTransaction().commit();

            // Testa a conexão executando uma simples consulta
            System.out.println("Conexão bem-sucedida!");

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Falha na conexão com o banco de dados.");
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
            if (emf != null && emf.isOpen()) {
                emf.close();
            }
        }
    }
}
