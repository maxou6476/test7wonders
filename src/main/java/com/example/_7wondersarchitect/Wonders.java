package com.example._7wondersarchitect;

public abstract class Wonders{
    String nom;
    int NBEtage;
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
        if (NBPiececonstru == 0){
            if (Cartes_Jaunes>=2){
                // enlever 2 cartes Jaunes
            } else if (Cartes_Jaunes >= 1 && Carte_Grise>=1 ){
                // enlever 1 carte jaune et 1 Carte Grise
            } else if (Carte_Grise>=2){
                // enlever 2 cartes grises [différentes ou pareilles]
            }
            NBPiececonstru++;
        }
        else if (NBPiececonstru == 1){
            if (Cartes_Jaunes>=2){
                // enlever 2 cartes Jaunes
            } else if (Cartes_Jaunes >= 1 && Carte_Grise>=1){
                // enlever 1 carte jaune et 1 Carte Grise
            } else if (Carte_Grise>=2){
                // enlever 2 cartes grises [pareilles]
            }
            NBPiececonstru++;
        }
        if (NBPiececonstru == 2){
            if (Cartes_Jaunes>=3){
                // enlever 3 cartes Jaunes
            } else if (Cartes_Jaunes >= 1 && Carte_Grise>=2 ){
                // enlever 1 carte Jaune et 2 Carte Grise [différentes ou pareilles]
            } else if (Cartes_Jaunes >= 2 && Carte_Grise>=1){
                // enlever 2 cartes jaunes et 1 Carte Grise
            }else if (Carte_Grise>=3){
                // enlever 3 cartes grises [différentes ou pareilles]
            }
            NBPiececonstru++;
        }
        if (NBPiececonstru == 3){
            if (Cartes_Jaunes>=3){
                // enlever 3 cartes Jaunes
            } else if (Cartes_Jaunes >= 1 && Carte_Grise>=2 ){
                // enlever 1 carte Jaune et 2 Carte Grise [pareilles]
            } else if (Cartes_Jaunes >= 2 && Carte_Grise>=1){
                // enlever 2 cartes jaunes et 1 Carte Grise
            }else if (Carte_Grise>=3){
                // enlever 3 cartes grises [pareilles]
            }
            NBPiececonstru++;
        }
        if (NBPiececonstru == 4){
            if (Cartes_Jaunes>=4){
                // enlever 4 cartes Jaunes
            } else if (Cartes_Jaunes >= 1 && Carte_Grise>=3 ){
                // enlever 1 Carte Jaune et 3 Cartes Grises [différentes ou pareilles]
            } else if (Cartes_Jaunes >= 2 && Carte_Grise>=2){
                // enlever 2 cartes jaunes et 2 Cartes Grises [différentes ou pareilles]
            } else if (Cartes_Jaunes >= 3 && Carte_Grise>=1){
                // enlever 3 cartes jaunes et 1 Carte Grise
            } else if (Carte_Grise>=4){
                // enlever 3 cartes grises [différentes ou pareilles]
            }
        }
    }

}
