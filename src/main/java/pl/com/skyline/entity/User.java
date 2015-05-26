package pl.com.skyline.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {

   @Id
   @Column(name="id")
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "User_id_gen")
   @SequenceGenerator(name="User_id_gen", sequenceName="User_id_seq", allocationSize=1)
   private int id;
    
   private String login;
    

   public int getId() {
       return id;
   }

   public void setId(int id) {
       this.id = id;
   }

   public String getLogin() {
       return login;
   }

   public void setLogin(String login) {
       this.login = login;
   }
   
   @Override
   public String toString(){
       return "id= " + id + ", login= " + login;
   }
}