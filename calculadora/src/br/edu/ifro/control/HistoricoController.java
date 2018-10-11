// alunos; Kássio Santos Barbosa/ Laiara Lorrayne 

package br.edu.ifro.control;

import br.edu.ifro.model.Calculadora;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class HistoricoController implements Initializable {

    @FXML
    private TableView<?> tbCalculadora;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listar();
    }    
    
    public void listar() {
          EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula");
        EntityManager em = emf.createEntityManager();
         Query query = em.createQuery("SELECT cal FROM Calculadora as cal");
     
        List<Calculadora> calculadoras = query.getResultList();
        ObservableList oCaixas = FXCollections.observableArrayList(calculadoras);                                 
        tbCalculadora.setItems(oCaixas);  
    }
    
}
