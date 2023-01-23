package com.example._7wondersarchitect;

public abstract class Wonders{
    String nom;
    int NBPiece;
    int Cartes_Jaunes=2;
    int Carte_Grise_Bois = 1;
    int Carte_Grise = Carte_Grise_Bois;
    int NBPiececonstru;

    public Wonders(String nom, int NBPiece, int NBPiececonstru){
        this.nom = nom;
        this.NBPiece = NBPiece;
        this.NBPiececonstru=NBPiececonstru;
    }

    // Etape 1 Construction
    public void construction(Joueurs joueurs){
        int nbbois=0,nbpierre=0,nbpapier=0,nbverre=0,nbor=0;
       /* for(int i = 0; i <= joueurs.getHand().size();i++) {
            if(joueurs.getHand().get(i).nom == "Bois"){
                nbbois++;
            }
            else if(joueurs.getHand().get(i).nom == "Pierre"){
                nbpierre++;
            }
            else if(joueurs.getHand().get(i).nom == "Papier"){
                nbpapier++;
            }
            else if(joueurs.getHand().get(i).nom == "Verre"){
                nbverre++;
            }
            else if(joueurs.getHand().get(i).nom == "Or"){
                nbor++;
            }


        }*/
        if (NBPiececonstru == 0){
            if (nbor >= 2) {
                    // enlever 2 cartes Jaunes
            } else if (nbor >= 1 && nbbois >= 1 || nbor >= 1 && nbpapier >= 1 || nbor >= 1 && nbpierre >= 1 || nbor >= 1 && nbverre >= 1 ) {
                    // enlever 1 carte jaune et 1 Carte Grise
            } else if (nbbois >= 2 || nbpapier >= 2 || nbpierre >= 2 || nbverre >= 2
                        || nbbois >= 1 && nbpapier >= 1 || nbbois >= 1 && nbpierre >= 1 || nbbois >= 1 && nbverre >= 1
                        ||nbpapier >= 1 && nbpierre >= 1 || nbpapier >= 1 && nbverre >= 1
                        ||nbpierre >= 1 && nbverre >= 1) {
                // enlever 2 cartes grises [différentes ou pareilles]
            }
            NBPiececonstru++;
        }
        else if (NBPiececonstru == 1){
            if (nbor>=2){
                // enlever 2 cartes Jaunes
            } else if (nbor >= 1 && nbbois >= 1 || nbor >= 1 && nbpapier >= 1 || nbor >= 1 && nbpierre >= 1 || nbor >= 1 && nbverre >= 1){
                // enlever 1 carte jaune et 1 Carte Grise
            } else if (nbbois >= 2 || nbpapier >= 2 || nbpierre >= 2 || nbverre >= 2){
                // enlever 2 cartes grises [pareilles]
            }
            NBPiececonstru++;
        }
        if (NBPiececonstru == 2){
            if (nbor>=3){
                // enlever 3 cartes Jaunes
            } else if (nbor >= 1 && nbbois >= 1 && nbpapier >=1 || nbor >= 1 && nbbois >= 1 && nbpierre >=1 || nbor >= 1 && nbbois >= 1 && nbverre >=1
                    || nbor >= 1 && nbpapier >= 1 && nbpierre >=1 || nbor >= 1 && nbpapier >= 1 && nbverre >=1
                    || nbor >= 1 && nbpierre >= 1 && nbverre >= 1
                    || nbor >= 1 && nbbois >= 2 || nbor >= 1 && nbpapier >= 2 || nbor >= 1 && nbpierre >= 2 || nbor >= 1 && nbverre >= 2){
                // enlever 1 carte Jaune et 2 Carte Grise [différentes ou pareilles]
            } else if (nbor >= 2 && nbbois >= 1 || nbor >= 2 && nbpapier >= 1 || nbor >= 2 && nbpierre >= 1 || nbor >= 2 && nbverre >= 1 ){
                // enlever 2 cartes jaunes et 1 Carte Grise
            }else if (nbbois >= 3 || nbpapier >= 3 || nbpierre >= 3 || nbverre >= 3
                    || nbbois >= 2 && nbpapier >= 1 || nbbois >= 2 && nbpierre >= 1 || nbbois >= 2 && nbverre >= 1
                    ||nbpapier >= 2 && nbpierre >= 1 || nbpapier >= 2 && nbverre >= 1
                    ||nbpierre >= 2 && nbverre >= 1
                    || nbbois >= 1 && nbpapier >= 2 || nbbois >= 1 && nbpierre >= 2 || nbbois >= 1 && nbverre >= 2
                    ||nbpapier >= 1 && nbpierre >= 2 || nbpapier >= 1 && nbverre >= 2
                    ||nbpierre >= 1 && nbverre >= 2
                    ||nbbois >= 1 && nbpierre >= 1 && nbverre >= 1 || nbbois >= 1 && nbpierre >= 1 && nbpapier >= 1
                    ||nbbois >= 1 && nbpapier >= 1 && nbverre >= 1 || nbpapier >= 1 && nbpierre >= 1 && nbverre >= 1){
                // enlever 3 cartes grises [différentes ou pareilles]
            }
            NBPiececonstru++;
        }
        if (NBPiececonstru == 3){
            if (nbor>=3){
                // enlever 3 cartes Jaunes
            } else if (nbor >= 1 && nbbois >= 2 || nbor >= 1 && nbpapier >= 2 || nbor >= 1 && nbpierre >= 2 || nbor >= 1 && nbverre >= 2 ){
                // enlever 1 carte Jaune et 2 Carte Grise [pareilles]
            } else if (nbor >= 2 && nbbois >= 1 || nbor >= 2 && nbpapier >= 1 || nbor >= 2 && nbpierre >= 1 || nbor >= 2 && nbverre >= 1 ){
                // enlever 2 cartes jaunes et 1 Carte Grise
            }else if (nbbois >= 3 || nbpapier >= 3 || nbpierre >= 3 || nbverre >= 3){
                // enlever 3 cartes grises [pareilles]
            }
            NBPiececonstru++;
        }
        if (NBPiececonstru == 4){
            if (nbor>=4){
                // enlever 4 cartes Jaunes
            } else if (nbor >= 1 && nbbois >= 1 && nbpierre >= 1 && nbverre >= 1
                    || nbor >= 1 && nbbois >= 1 && nbpierre >= 1 && nbpapier >= 1
                    || nbor >= 1 && nbbois >= 1 && nbpapier >= 1 && nbverre >= 1
                    || nbor >= 1 && nbpapier >= 1 && nbpierre >= 1 && nbverre >= 1
                    || nbor >= 1 && nbbois >= 2 && nbpapier >= 1
                    || nbor >= 1 && nbbois >= 2 && nbpierre >= 1
                    || nbor >= 1 && nbbois >= 2 && nbverre >= 1
                    || nbor >= 1 && nbpapier >= 2 && nbbois >= 1
                    || nbor >= 1 && nbpapier >= 2 && nbpierre >= 1
                    || nbor >= 1 && nbpapier >= 2 && nbverre >= 1
                    || nbor >= 1 && nbpierre >= 2 && nbbois >= 1
                    || nbor >= 1 && nbpierre >= 2 && nbpapier >= 1
                    || nbor >= 1 && nbpierre >= 2 && nbverre >= 1
                    || nbor >= 1 && nbverre >= 2 && nbbois >= 1
                    || nbor >= 1 && nbverre >= 2 && nbpapier >= 1
                    || nbor >= 1 && nbverre >= 2 && nbpierre >= 1
                    || nbor >= 1 && nbbois >= 3
                    || nbor >= 1 && nbpapier >= 3
                    || nbor >= 1 && nbpierre >= 3
                    || nbor >= 1 && nbverre >= 3){
                // enlever 1 Carte Jaune et 3 Cartes Grises [différentes ou pareilles]
            } else if (nbor >= 2 && nbbois >= 1 && nbpapier >=1 || nbor >= 2 && nbbois >= 1 && nbpierre >=1 || nbor >= 2 && nbbois >= 1 && nbverre >=1
                    || nbor >= 2 && nbpapier >= 1 && nbpierre >=1 || nbor >= 2 && nbpapier >= 1 && nbverre >=1
                    || nbor >= 2 && nbpierre >= 1 && nbverre >= 1
                    || nbor >= 2 && nbbois >= 2 || nbor >= 2 && nbpapier >= 2 || nbor >= 2 && nbpierre >= 2 || nbor >= 2 && nbverre >= 2){
                // enlever 2 cartes jaunes et 2 Cartes Grises [différentes ou pareilles]
            } else if (nbor >= 3 && nbbois >= 1 || nbor >= 3 && nbpapier >= 1 || nbor >= 3 && nbpierre >= 1 || nbor >= 3 && nbverre >= 1){
                // enlever 3 cartes jaunes et 1 Carte Grise
            } else if (nbbois >= 4 ||nbpapier >= 4||nbverre >= 4||nbpierre >= 4){
                // enlever 4 cartes grises [différentes ou pareilles]
            }
            NBPiececonstru++;
        }
    }

}
