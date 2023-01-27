package com.example._7wondersarchitect;

public abstract class Wonders{
    protected String nom;
    protected int NBPiece;
    protected int Cartes_Jaunes=2;
    protected int Carte_Grise_Bois = 1;
    protected int Carte_Grise = Carte_Grise_Bois;
    protected int NBPiececonstru;

    public Wonders(String nom, int NBPiece, int NBPiececonstru){
        this.nom = nom;
        this.NBPiece = NBPiece;
        this.NBPiececonstru=NBPiececonstru;
    }

    public String getnomM(){
        return nom;
    }
    public int getUpgrade(){
        return this.NBPiececonstru;
    }

    // Etape 1 Construction
    public void construction(Joueurs joueurs){
        int nbbois=0,nbpierre=0,nbparchemin=0,nbverre=0,nbor=0;


        for(int i = 0; i <= joueurs.showcard().size()-1;i++) {
            System.out.println(joueurs.showcard().get(i).getNom());
            if(joueurs.showcard().get(i).getNom() == "Bois"){
                nbbois++;
            }
            else if(joueurs.showcard().get(i).getNom() == "Pierre"){
                nbpierre++;
            }
            else if(joueurs.showcard().get(i).getNom() == "Parchemin"){
                nbparchemin++;
            }
            else if(joueurs.showcard().get(i).getNom() == "Verre"){
                nbverre++;
            }
            else if(joueurs.showcard().get(i).getNom() == "Or"){
                nbor++;
            }
        }
        System.out.println(nbbois + " " + nbpierre + " " + nbparchemin +" " + nbverre +" " + nbor);
        if (NBPiececonstru == 0){
            if (nbor >= 2) {
                joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                NBPiececonstru++;
            } else if (nbor >= 1 && nbbois >= 1 || nbor >= 1 && nbparchemin >= 1 || nbor >= 1 && nbpierre >= 1 || nbor >= 1 && nbverre >= 1 ) {
                if(nbor >= 1 && nbbois >= 1){
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    NBPiececonstru++;
                } else if (nbor >= 1 && nbparchemin >=1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    NBPiececonstru++;
                }else if (nbor >= 1 && nbpierre >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    NBPiececonstru++;
                }else if (nbor >= 1 && nbverre >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }
            } else if (nbbois >= 2 || nbparchemin >= 2 || nbpierre >= 2 || nbverre >= 2
                    || nbbois >= 1 && nbparchemin >= 1 || nbbois >= 1 && nbpierre >= 1 || nbbois >= 1 && nbverre >= 1
                    ||nbparchemin >= 1 && nbpierre >= 1 || nbparchemin >= 1 && nbverre >= 1
                    ||nbpierre >= 1 && nbverre >= 1) {
                    NBPiececonstru++;
                // enlever 2 cartes grises [différentes ou pareilles]
                if(nbbois > 2){
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    NBPiececonstru++;
                } else if (nbparchemin>2) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    NBPiececonstru++;
                }else if (nbpierre>2) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    NBPiececonstru++;
                }else if (nbverre>2) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }else if (nbbois >= 1 && nbparchemin >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    NBPiececonstru++;
                }else if (nbbois >= 1 && nbpierre >= 1 ) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    NBPiececonstru++;
                }else if (nbbois >= 1 && nbverre >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }else if (nbparchemin >= 1 && nbpierre >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    NBPiececonstru++;
                }else if (nbparchemin >= 1 && nbverre >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }else if (nbpierre >= 1 && nbverre >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }
            }
        }
        else if (NBPiececonstru == 1){
            if (nbor>=2){
                joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                NBPiececonstru++;
            } else if (nbor >= 1 && nbbois >= 1 || nbor >= 1 && nbparchemin >= 1 || nbor >= 1 && nbpierre >= 1 || nbor >= 1 && nbverre >= 1){
                // enlever 1 carte jaune et 1 Carte Grise
                if(nbor >= 1 && nbbois >= 1){
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    NBPiececonstru++;
                } else if (nbor >= 1 && nbparchemin >=1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    NBPiececonstru++;
                }else if (nbor >= 1 && nbpierre >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    NBPiececonstru++;
                }else if (nbor >= 1 && nbverre >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }
            } else if (nbbois >= 2 || nbparchemin >= 2 || nbpierre >= 2 || nbverre >= 2){
                // enlever 2 cartes grises [pareilles]
                if(nbbois >= 2){
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    NBPiececonstru++;
                } else if (nbparchemin >= 2) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    NBPiececonstru++;
                }else if (nbpierre >= 2) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    NBPiececonstru++;
                }else if (nbverre >= 2) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }
            }
        }
        if (NBPiececonstru == 2){
            if (nbor>=3){
                joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                NBPiececonstru++;
            } else if (nbor >= 1 && nbbois >= 1 && nbparchemin >=1 || nbor >= 1 && nbbois >= 1 && nbpierre >=1 || nbor >= 1 && nbbois >= 1 && nbverre >=1
                    || nbor >= 1 && nbparchemin >= 1 && nbpierre >=1 || nbor >= 1 && nbparchemin >= 1 && nbverre >=1
                    || nbor >= 1 && nbpierre >= 1 && nbverre >= 1
                    || nbor >= 1 && nbbois >= 2 || nbor >= 1 && nbparchemin >= 2 || nbor >= 1 && nbpierre >= 2 || nbor >= 1 && nbverre >= 2){
                // enlever 1 carte Jaune et 2 Carte Grise [différentes ou pareilles]
                if(nbor >= 1 && nbbois >= 1 && nbparchemin >=1){
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    NBPiececonstru++;
                } else if (nbor >= 1 && nbbois >= 1 && nbpierre >=1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    NBPiececonstru++;
                }else if (nbor >= 1 && nbbois >= 1 && nbverre >=1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }else if (nbor >= 1 && nbparchemin >= 1 && nbpierre >=1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    NBPiececonstru++;
                }else if (nbor >= 1 && nbparchemin >= 1 && nbverre >=1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }else if (nbor >= 1 && nbpierre >= 1 && nbverre >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }else if (nbor >= 1 && nbbois >= 2) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    NBPiececonstru++;
                }else if (nbor >= 1 && nbparchemin >= 2) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    NBPiececonstru++;
                }else if (nbor >= 1 && nbpierre >= 2) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    NBPiececonstru++;
                }else if (nbor >= 1 && nbverre >= 2) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }
            } else if (nbor >= 2 && nbbois >= 1 || nbor >= 2 && nbparchemin >= 1 || nbor >= 2 && nbpierre >= 1 || nbor >= 2 && nbverre >= 1 ){
                // enlever 2 cartes jaunes et 1 Carte Grise
                if(nbor >= 2 && nbbois >= 1){
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    NBPiececonstru++;
                } else if (nbor >= 2 && nbparchemin >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    NBPiececonstru++;
                }else if (nbor >= 2 && nbpierre >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    NBPiececonstru++;
                }else if (nbor >= 2 && nbverre >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }
            }else if (nbbois >= 3 || nbparchemin >= 3 || nbpierre >= 3 || nbverre >= 3
                    || nbbois >= 2 && nbparchemin >= 1 || nbbois >= 2 && nbpierre >= 1 || nbbois >= 2 && nbverre >= 1
                    ||nbparchemin >= 2 && nbpierre >= 1 || nbparchemin >= 2 && nbverre >= 1
                    ||nbpierre >= 2 && nbverre >= 1
                    || nbbois >= 1 && nbparchemin >= 2 || nbbois >= 1 && nbpierre >= 2 || nbbois >= 1 && nbverre >= 2
                    ||nbparchemin >= 1 && nbpierre >= 2 || nbparchemin >= 1 && nbverre >= 2
                    ||nbpierre >= 1 && nbverre >= 2
                    ||nbbois >= 1 && nbpierre >= 1 && nbverre >= 1 || nbbois >= 1 && nbpierre >= 1 && nbparchemin >= 1
                    ||nbbois >= 1 && nbparchemin >= 1 && nbverre >= 1 || nbparchemin >= 1 && nbpierre >= 1 && nbverre >= 1){
                // enlever 3 cartes grises [différentes ou pareilles]
                if(nbbois >= 3 ){
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    NBPiececonstru++;
                } else if ( nbparchemin >= 3 ) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    NBPiececonstru++;
                }else if (nbpierre >= 3 ) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    NBPiececonstru++;
                }else if (nbverre >= 3) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }else if (nbbois >= 2 && nbparchemin >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    NBPiececonstru++;
                }else if (nbbois >= 2 && nbpierre >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    NBPiececonstru++;
                }else if (nbbois >= 2 && nbverre >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }else if (nbparchemin >= 2 && nbpierre >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    NBPiececonstru++;
                }else if (nbparchemin >= 2 && nbverre >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }else if (nbpierre >= 2 && nbverre >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }else if (nbbois >= 1 && nbparchemin >= 2) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    NBPiececonstru++;
                }else if (nbbois >= 1 && nbpierre >= 2) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    NBPiececonstru++;
                }else if (nbbois >= 1 && nbverre >= 2) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }else if (nbparchemin >= 1 && nbpierre >= 2) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    NBPiececonstru++;
                }else if (nbparchemin >= 1 && nbverre >= 2) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }else if (nbpierre >= 1 && nbverre >= 2) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }else if (nbbois >= 1 && nbpierre >= 1 && nbverre >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }else if (nbbois >= 1 && nbpierre >= 1 && nbparchemin >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    NBPiececonstru++;
                }else if (nbbois >= 1 && nbparchemin >= 1 && nbverre >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }else if (nbparchemin >= 1 && nbpierre >= 1 && nbverre >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }
            }
        }
        if (NBPiececonstru == 3){
            if (nbor>=3){
                joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                NBPiececonstru++;
            } else if (nbor >= 1 && nbbois >= 2 || nbor >= 1 && nbparchemin >= 2 || nbor >= 1 && nbpierre >= 2 || nbor >= 1 && nbverre >= 2 ){
                // enlever 1 carte Jaune et 2 Carte Grise [pareilles]
                if(nbor >= 1 && nbbois >= 2){
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    NBPiececonstru++;
                } else if (nbor >= 1 && nbparchemin >= 2) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    NBPiececonstru++;
                }else if (nbor >= 1 && nbpierre >= 2) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    NBPiececonstru++;
                }else if (nbor >= 1 && nbverre >= 2) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }
            } else if (nbor >= 2 && nbbois >= 1 || nbor >= 2 && nbparchemin >= 1 || nbor >= 2 && nbpierre >= 1 || nbor >= 2 && nbverre >= 1 ){
                // enlever 2 cartes jaunes et 1 Carte Grise
                if(nbor >= 2 && nbbois >= 1){
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    NBPiececonstru++;
                } else if (nbor >= 2 && nbparchemin >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    NBPiececonstru++;
                }else if (nbor >= 2 && nbpierre >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    NBPiececonstru++;
                }else if (nbor >= 2 && nbverre >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }
            }else if (nbbois >= 3 || nbparchemin >= 3 || nbpierre >= 3 || nbverre >= 3){
                // enlever 3 cartes grises [pareilles]
                if(nbbois >= 3){
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    NBPiececonstru++;
                } else if (nbparchemin >= 3) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    NBPiececonstru++;
                }else if (nbpierre >= 3) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    NBPiececonstru++;
                }else if (nbverre >= 3) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }
            }
        }
        if (NBPiececonstru == 4){
            if (nbor>=4){
                joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                NBPiececonstru++;
            } else if (nbor >= 1 && nbbois >= 1 && nbpierre >= 1 && nbverre >= 1
                    || nbor >= 1 && nbbois >= 1 && nbpierre >= 1 && nbparchemin >= 1
                    || nbor >= 1 && nbbois >= 1 && nbparchemin >= 1 && nbverre >= 1
                    || nbor >= 1 && nbparchemin >= 1 && nbpierre >= 1 && nbverre >= 1
                    || nbor >= 1 && nbbois >= 2 && nbparchemin >= 1
                    || nbor >= 1 && nbbois >= 2 && nbpierre >= 1
                    || nbor >= 1 && nbbois >= 2 && nbverre >= 1
                    || nbor >= 1 && nbparchemin >= 2 && nbbois >= 1
                    || nbor >= 1 && nbparchemin >= 2 && nbpierre >= 1
                    || nbor >= 1 && nbparchemin >= 2 && nbverre >= 1
                    || nbor >= 1 && nbpierre >= 2 && nbbois >= 1
                    || nbor >= 1 && nbpierre >= 2 && nbparchemin >= 1
                    || nbor >= 1 && nbpierre >= 2 && nbverre >= 1
                    || nbor >= 1 && nbverre >= 2 && nbbois >= 1
                    || nbor >= 1 && nbverre >= 2 && nbparchemin >= 1
                    || nbor >= 1 && nbverre >= 2 && nbpierre >= 1
                    || nbor >= 1 && nbbois >= 3
                    || nbor >= 1 && nbparchemin >= 3
                    || nbor >= 1 && nbpierre >= 3
                    || nbor >= 1 && nbverre >= 3){
                // enlever 1 Carte Jaune et 3 Cartes Grises [différentes ou pareilles]
                if(nbor >= 1 && nbbois >= 1 && nbpierre >= 1 && nbverre >= 1){
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                } else if (nbor >= 1 && nbbois >= 1 && nbpierre >= 1 && nbparchemin >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    NBPiececonstru++;
                }else if (nbor >= 1 && nbbois >= 1 && nbparchemin >= 1 && nbverre >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }else if (nbor >= 1 && nbparchemin >= 1 && nbpierre >= 1 && nbverre >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }else if (nbor >= 1 && nbbois >= 2 && nbparchemin >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    NBPiececonstru++;
                }else if (nbor >= 1 && nbbois >= 2 && nbpierre >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    NBPiececonstru++;
                }else if (nbor >= 1 && nbbois >= 2 && nbverre >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }else if (nbor >= 1 && nbparchemin >= 2 && nbbois >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    NBPiececonstru++;
                }else if (nbor >= 1 && nbparchemin >= 2 && nbpierre >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    NBPiececonstru++;
                }else if (nbor >= 1 && nbparchemin >= 2 && nbverre >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }else if (nbor >= 1 && nbpierre >= 2 && nbbois >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    NBPiececonstru++;
                }else if (nbor >= 1 && nbpierre >= 2 && nbparchemin >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    NBPiececonstru++;
                }else if (nbor >= 1 && nbpierre >= 2 && nbverre >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }else if (nbor >= 1 && nbverre >= 2 && nbbois >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    NBPiececonstru++;
                }else if (nbor >= 1 && nbverre >= 2 && nbparchemin >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    NBPiececonstru++;
                }else if (nbor >= 1 && nbverre >= 2 && nbpierre >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    NBPiececonstru++;
                }else if (nbor >= 1 && nbbois >= 3) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    NBPiececonstru++;
                }else if (nbor >= 1 && nbparchemin >= 3) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    NBPiececonstru++;
                }else if (nbor >= 1 && nbpierre >= 3) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    NBPiececonstru++;
                }else if (nbor >= 1 && nbverre >= 3) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }
            } else if (nbor >= 2 && nbbois >= 1 && nbparchemin >=1 || nbor >= 2 && nbbois >= 1 && nbpierre >=1 || nbor >= 2 && nbbois >= 1 && nbverre >=1
                    || nbor >= 2 && nbparchemin >= 1 && nbpierre >=1 || nbor >= 2 && nbparchemin >= 1 && nbverre >=1
                    || nbor >= 2 && nbpierre >= 1 && nbverre >= 1
                    || nbor >= 2 && nbbois >= 2 || nbor >= 2 && nbparchemin >= 2 || nbor >= 2 && nbpierre >= 2 || nbor >= 2 && nbverre >= 2){
                // enlever 2 cartes jaunes et 2 Cartes Grises [différentes ou pareilles]
                if(nbor >= 2 && nbbois >= 1 && nbparchemin >=1 ){
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    NBPiececonstru++;
                } else if (nbor >= 2 && nbbois >= 1 && nbpierre >=1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    NBPiececonstru++;
                }else if (nbor >= 2 && nbbois >= 1 && nbverre >=1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }else if (nbor >= 2 && nbparchemin >= 1 && nbpierre >=1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    NBPiececonstru++;
                }else if (nbor >= 2 && nbparchemin >= 1 && nbverre >=1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }else if (nbor >= 2 && nbpierre >= 1 && nbverre >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }else if (nbor >= 2 && nbbois >= 2) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    NBPiececonstru++;
                }else if (nbor >= 2 && nbparchemin >= 2) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    NBPiececonstru++;
                }else if (nbor >= 2 && nbpierre >= 2) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    NBPiececonstru++;
                }else if (nbor >= 2 && nbverre >= 2) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }
            } else if (nbor >= 3 && nbbois >= 1 || nbor >= 3 && nbparchemin >= 1 || nbor >= 3 && nbpierre >= 1 || nbor >= 3 && nbverre >= 1){
                // enlever 3 cartes jaunes et 1 Carte Grise
                if(nbor >= 3 && nbbois >= 1){
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    NBPiececonstru++;
                } else if (nbor >= 3 && nbparchemin >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    NBPiececonstru++;
                }else if (nbor >= 3 && nbpierre >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    NBPiececonstru++;
                }else if (nbor >= 3 && nbverre >= 1) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Or"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }
            } else if (nbbois >= 4 ||nbparchemin >= 4||nbverre >= 4||nbpierre >= 4){
                // enlever 4 cartes grises [différentes ou pareilles]
                if(nbbois >= 4){
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Bois"));
                    NBPiececonstru++;
                } else if (nbparchemin >= 4) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Parchemin"));
                    NBPiececonstru++;
                }else if (nbverre >= 4) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Verre"));
                    NBPiececonstru++;
                }else if (nbpierre >= 4) {
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    joueurs.showcard().removeIf(obj -> obj.getNom().equals("Pierre"));
                    NBPiececonstru++;
                }
            }
        }
    }

}
