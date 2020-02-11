package dao;

import domain.Modalidade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModalidadeDAO implements DAO<Modalidade> {
    private EntityManagerFactory entityManagerFactory = null;
    private EntityManager entityManager = null;

    public void begin(){
        this.entityManagerFactory = Persistence.createEntityManagerFactory("reserva-pu");
        this.entityManager=entityManagerFactory.createEntityManager();
    }

    public void close(){
        if (entityManager!=null){
            entityManager.close();
        }
        if (entityManagerFactory!=null){
            entityManagerFactory.close();
        }
    }


    @Override
    public void salvar(Modalidade domain) {
        begin();
        this.entityManager.persist(domain);
        close();
//        try {
//            String sql = "INSERT INTO modalidade(nome) VALUES (?)";
//
//            Connection conexao = JDBCConnection.getConnection();
//            PreparedStatement ps = conexao.prepareStatement(sql);
//
//            ps.setString(1, domain.getNome());
//            ps.execute();
//
//        } catch (SQLException exception){
//            exception.printStackTrace();
//
//        }
    }

    @Override
    public void atualizar(Modalidade domain) {
        begin();
        this.entityManager.persist(domain);
        close();
//        try {
//            String sql = "UPDATE modalidade SET nome = (?) WHERE id_modalidade = (?)";
//
//            Connection conexao = JDBCConnection.getConnection();
//            PreparedStatement ps = conexao.prepareStatement(sql);
//
//            ps.setString(1, domain.getNome());
//            ps.setInt(2, domain.getIdModalidade());
//
//            ps.execute();
//
//        } catch (SQLException exception) {
//            exception.printStackTrace();
//        }
    }

    @Override
    public void deletar(Modalidade domain) {
        begin();
        this.entityManager.remove(domain);
        close();
//        try {
//            String sql = "DELETE FROM modalidade WHERE id_modalidade = (?)";
//
//            Connection conexao = JDBCConnection.getConnection();
//            PreparedStatement ps = conexao.prepareStatement(sql);
//
//            ps.setInt(1, domain.getIdModalidade());
//
//            ps.execute();
//
//        } catch (SQLException exception) {
//            exception.printStackTrace();
//        }
    }

    @Override
    public List<Modalidade> listarTodos() {
        begin();
        this.entityManager.createQuery("SELECT m FROM Modalidade m");
        close();

//        try {
//            String sql = "SELECT * FROM modalidade";
//
//            Connection conexao = JDBCConnection.getConnection();
//            PreparedStatement ps = conexao.prepareStatement(sql);
//
//            ResultSet resultado = ps.executeQuery();
//            List<Modalidade> modalidades = new ArrayList<>();
//
//            while (resultado.next()){
//                Modalidade modalidade = new Modalidade();
//
//                modalidade.setIdModalidade(resultado.getInt("id_modalidade"));
//                modalidade.setNome(resultado.getString("nome"));
//
//                modalidades.add(modalidade);
//            }
//
//            return modalidades;
//        } catch (SQLException exception) {
//            exception.printStackTrace();
//        }
        return null;
    }

}
