public class QuadratoMagico {
    int dim = 3;
    int[][] quadrato = new int[dim][dim];
    int passaggi;

    public QuadratoMagico() {
        for(int i = 0;i<quadrato.length; i++){
            for(int j = 0; j < quadrato[i].length; j++){
                quadrato[i][j] = 0;
            }
        }
    }

    public boolean muovi(int rig, int col, int nInseriti){
        passaggi = nInseriti;
        if(dim*dim == nInseriti) {
            if (isValida())
                return true;
            return false;
        }

        for (int i = 1; i <= dim*dim; i++) {
            if (!isAlreadyIn(i)) {
                quadrato[rig][col] = i;
                to_String();
                if (col + 1 == dim) {
                    if (muovi(rig + 1, 0, nInseriti + 1))
                        return true;
                }else if (muovi(rig, col + 1, nInseriti + 1))
                        return true;

                quadrato[rig][col] = 0;
                to_String();
            }
        }


        return false;
    }
    private boolean isAlreadyIn(int n){
        for (int i = 0; i< quadrato.length; i++)
            for (int j = 0; j < quadrato[i].length; j++)
                if (n == quadrato[i][j]) return true;
        return false;
    }
    private boolean isValida(){
        int somRig, somCol, somDiag1 = 0, somDiag2 = 0;
        for (int i = 0; i < quadrato.length; i++) { //somma righe
            somRig = 0;
            for (int j = 0; j < quadrato[i].length; j++)
                somRig += quadrato[i][j];
            if (somRig != dim*(dim*dim+1)/2)
                return false;
        }
        for (int i = 0; i < quadrato.length; i++) { //somma colonne
            somCol = 0;
            for (int j = 0; j < quadrato[i].length; j++)
                somCol += quadrato[j][i];
            if (somCol != dim*(dim*dim+1)/2)
                return false;
        }
        for (int i = 0; i < quadrato.length; i++){ //diag princ
            somDiag1 += quadrato[i][i];
        }
        if(somDiag1 != dim*(dim*dim+1)/2)
            return false;

        //diag sec
        for (int i = 0, j = quadrato.length - 1; i< quadrato.length; i++,j--)
            somDiag2 += quadrato[i][j];

        /*
        int k = quadrato.length - 1;
        for (int i = 0; i < quadrato.length; i++) {
            somDiag2 += quadrato[i][k];
            k--;
        }*/

        if(somDiag2 != dim*(dim*dim+1)/2)
            return false;
        return true;
    }


    public void to_String() {
        String toReturn = "";
        for(int i = 0; i < quadrato.length; i++){
            for(int j = 0; j < quadrato[i].length; j++)
                toReturn += quadrato[i][j] + " ";
            toReturn += "\n";
        }
        System.out.println(passaggi);
        System.out.println(toReturn);
        //return toReturn;
    }
}
