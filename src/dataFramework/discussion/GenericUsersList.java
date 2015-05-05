package dataFramework.discussion;

import java.util.ArrayList;

import dataFramework.users.GenericUser;

/**
 * @author groupe1
 *
 * @param <U>
 */
public class GenericUsersList<U extends GenericUser> {
    private ArrayList<U> usersList;
    
    /** Cree un nouveau GenericUsersList
     */
    public GenericUsersList() {
        usersList = new ArrayList<U>();
    }

    /** Ajoute un nouveau utilisateur a  la liste
     * @param user L'utilisateur a  ajouter
     */
    public void addUser(U user) {
        usersList.add(user);
    }
    
    /** Supprime un utilisateur a  la liste
     * @param user L'utilisateur a  supprimer
     */    
    public void removeUser(U user) {
        usersList.remove(user);
    }

    /** Recupere un utilisateur en fonction de son index dans la liste
     * @param index Index de l'utilisateur
     * @return L'utilisateur recherche
     */
    public U getUser(int index) {
        return usersList.get(index);
    }

    /** Recupere un utilisateur en fonction de son pseudo
     * @param login Pseudo de l'utilisateur
     * @return L'utilisateur recherche
     */
    public U getUser(String login) {
        for(U usersList1 : usersList) {
            if (usersList1.getLogin().equals(login)) {
                return usersList1;
            }
        }
        return null;
    }
    
    /** Informe sur la presence d'un utilisateur dans la liste
     * @param user L'utilisateur recherche
     * @return true si l'utilisateur existe dans la liste, sinon false
     */    
    public boolean exists(U user) {
        for(U usersList1 : usersList) {
            if(usersList1.equals(user)) return true;
        }
        return false;
    }
    
    /** Recupere la liste des utilisateurs
     * @return La liste des utilisateurs
     */
    public ArrayList<U> getUserList() {
      return usersList;
    }
    
    /** Recupere la taille de la liste des utilisateurs
     * @return la taille de la liste des utilisateurs
     */
    public int size(){
    	return usersList.size();
    }
    
}