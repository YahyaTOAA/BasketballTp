package tps2


//Question 1 Partie 1
//data class Joueur(val nom: String, val numero: Int, val equipe: Equipe, val points: Int)


fun main() {
//Question 2 Partie 1
//    val listeJoueurs = mutableListOf<Joueur>()
//
//    listeJoueurs.add(Joueur("Hakimi", 10, Equipe.OCS, 5))
//    listeJoueurs.add(Joueur("Ronaldo", 20, Equipe.OCK, 8))
//    listeJoueurs.add(Joueur("Mike", 30, Equipe.OCS, 3))

//Question 3 Partie 1
//    listeJoueurs.add(Joueur("Salah", 40, Equipe.OCK, 6))

    //Question 3 Partie 5

    val equipe1 = Equipe(Pays.MAROC, "OCS")
    val equipe2 = Equipe(Pays.TUNISIE, "OCK")
    val equipe3 = Equipe(Pays.EGYPTE, "RCA")
    val equipe4 = Equipe(Pays.ALGERIE, "WAC")

    val joueur1 = Joueur("Hakimi", 10, equipe.OCS, Pays.MAROC, 5)
    val joueur2 = Joueur("ronaldo", 20, equipe.OCK, Pays.TUNISIE, 8)
    val joueur3 = Joueur("Mike", 30, equipe.OCS, Pays.MAROC, 3)
    val joueur4 = Joueur("SarahSalah", 40, equipe.OCK, Pays.TUNISIE, 6)

    equipe1.ajout(joueur1)
    equipe2.ajout(joueur2)
    equipe3.ajout(joueur3)
    equipe4.ajout(joueur4)

    println("Liste des joueurs de l'équipe 1:")
    equipe1.affichage()

    println("Liste des joueurs de l'équipe 2:")
    equipe2.affichage()

    println("Mise à jour des points du joueur 1:")
    equipe1.setPoints(joueur1, 10)

    println("Suppression du joueur 2:")
    equipe2.suppression(joueur2)

    println("Liste des joueurs de l'équipe 1 après les modifications:")
    equipe1.affichage()

    println("Liste des joueurs de l'équipe 2 après la suppression:")
    equipe2.affichage()


}
//Question 1 Partie 2
enum class equipe {
    OCS, OCK
}
//Question 1 Partie 3
enum class Pays {
    MAROC, TUNISIE, EGYPTE, ALGERIE, MOURITANIE
}
//Question 2 Partie 3
data class Joueur(val nom: String, val numero: Int, val equipe: equipe, val pays: Pays, val points: Int)

//Question 3 Partie 3
class Equipe(val pays: Pays, val sigle: String) {
    val listeJoueurs = mutableListOf<Joueur>()

    fun ajout(joueur: Joueur): Boolean {
        if (recherche(joueur) == -1) {
            listeJoueurs.add(joueur)
            return true
        }
        return false
    }

    fun recherche(joueur: Joueur): Int {
        for (i in 0 until listeJoueurs.size) {
            if (listeJoueurs[i].nom == joueur.nom) {
                return i
            }
        }
        return -1
    }

    fun suppression(joueur: Joueur): Boolean {
        val index = recherche(joueur)
        if (index != -1) {
            listeJoueurs.removeAt(index)
            return true
        }
        return false
    }

    fun miseAJour(joueur: Joueur): Boolean {
        val index = recherche(joueur)
        if (index != -1) {
            listeJoueurs[index] = joueur
            return true
        }
        return false
    }

    fun affichage() {
        for (joueur in listeJoueurs) {
            println(joueur)
        }
    }
    //Question 4 Partie 3
    fun setPoints(joueur: Joueur, points: Int) {
        val index = recherche(joueur)
        if (index != -1) {
            val joueurModifie = listeJoueurs[index].copy(points = points)
            listeJoueurs[index] = joueurModifie
        }
    }
}