public class DemonstraceAlgoritmu {
    private String text;
    private String vzorek;

    public DemonstraceAlgoritmu(String text, String vzorek) {
        this.text = text;
        this.vzorek = vzorek;
    }

    public enum Kroky { UVOD, VNITRNI_CYKLUS, HLAVNI_PODMINKA, PODMINKA_SPLNENI_UKOLU,
        PODMINKA_KONEC_TEXTU, KONEC };
    public Kroky aktualniKrok;
    private String popisKroku;
    private int pocetProvedenychKroku;
    private int indexTextu;
    private int indexVzorku;
    private boolean hledej;
    public static int konec;
    public static String popis;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getVzorek() {
        return vzorek;
    }

    public void setVzorek(String vzorek) {
        this.vzorek = vzorek;
    }

    public Kroky getAktualniKrok() {
        return aktualniKrok;
    }

    public void setAktualniKrok(Kroky aktualniKrok) {
        this.aktualniKrok = aktualniKrok;
    }

    public String getPopisKroku() {
        return popisKroku;
    }

    public void setPopisKroku(String popisKroku) {
        this.popisKroku = popisKroku;
    }

    public int getPocetProvedenychKroku() {
        return pocetProvedenychKroku;
    }

    public void setPocetProvedenychKroku(int pocetProvedenychKroku) {
        this.pocetProvedenychKroku = pocetProvedenychKroku;
    }

    public int getIndexTextu() {
        return indexTextu;
    }

    public void setIndexTextu(int indexTextu) {
        this.indexTextu = indexTextu;
    }

    public int getIndexVzorku() {
        return indexVzorku;
    }

    public void setIndexVzorku(int indexVzorku) {
        this.indexVzorku = indexVzorku;
    }
    public static String getPopis() {
        return popis;
    }

    public static void setPopis(String popis) {
        DemonstraceAlgoritmu.popis = popis;
    }

    public void naZacatek() {
        // Inicializace všech atributů na počáteční hodnoty
        aktualniKrok = Kroky.UVOD;
        pocetProvedenychKroku = 0;
        indexTextu = 0;
        indexVzorku = 0;
        hledej = true;
    }

    public void provedKrok() {
        switch (aktualniKrok) {
            case UVOD:

                uvod();
                break;
            case VNITRNI_CYKLUS:

                vnitrnicyklus();
                break;
            case HLAVNI_PODMINKA:

                hlavnipodminka();
                break;
            case PODMINKA_SPLNENI_UKOLU:

                podminkasplneniukolu();
                break;
            case PODMINKA_KONEC_TEXTU:

                podminkakonectextu();
                break;
            case KONEC:
                konec();
                break;

            }
        }

    private void uvod() {
        popis = "Začínám hledat vzorek '"+ getVzorek() +"' v textu '"+ getText() +"'.";
        aktualniKrok = Kroky.VNITRNI_CYKLUS;
    }

    private void vnitrnicyklus() {
        popis = "Porovnávám znaky '"+ getText().charAt(indexTextu) +"' a '"+ getVzorek().charAt(indexVzorku) +"'.";
        aktualniKrok = Kroky.HLAVNI_PODMINKA;
    }

    private void hlavnipodminka() {
        if (indexTextu < text.length() && indexVzorku < vzorek.length() &&
                text.charAt(indexTextu) == vzorek.charAt(indexVzorku)) {
            popis = "Znaky "+ getVzorek().charAt(indexVzorku) +" se shodují.";
            aktualniKrok = Kroky.PODMINKA_SPLNENI_UKOLU;
        } else {
            popis = "Znak "+ getVzorek().charAt(indexVzorku) +" se neshoduje.";
            indexVzorku = 0;
            aktualniKrok = Kroky.PODMINKA_KONEC_TEXTU;
        }
    }

    private void podminkasplneniukolu() {
        if (indexVzorku == vzorek.length() -1) {
            popis = "Vzorek hledaný v textu skončil.";
            konec = 1;
            aktualniKrok = Kroky.KONEC;
        } else {
            popis = "Pokračuji v hledání a posunuji se na další písmeno hledaného vzorku.";
            indexVzorku += 1;
            indexTextu += 1;
            aktualniKrok = Kroky.HLAVNI_PODMINKA;

        }
    }

    private void podminkakonectextu() {
        if (indexTextu == text.length() - 1) {
            popis = "Text ve kterém se hledal vzorek skončil.";
            konec = 0;
            aktualniKrok = Kroky.KONEC;
        } else {
            popis = "Pokračuji v hledání a posunuji se na další písmeno hledaného vzorku.";
            indexTextu += 1;
            indexVzorku = 0;
            aktualniKrok = Kroky.VNITRNI_CYKLUS;
        }
    }

    private void konec() {
    }


}


