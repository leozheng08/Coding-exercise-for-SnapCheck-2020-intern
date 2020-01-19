import java.util.Arrays;

public class Ecryption {

    String Ecryption(String data){
        //the constraint of input string is from 1-81;
        int[] rowAndColumn = Sqrt(data);
        int row = rowAndColumn[0];
        int column = rowAndColumn[1];
        //convert String to char array;
        char[] dataArray = data.toCharArray();
        //input only characters in the range ascii[a-z].
        char[][] contain = new char[row][column];
        //convert 1d to 2d array;
        for(int i=0;i<dataArray.length;i++){
            contain[i/column][i%column] = dataArray[i];
        }
        //read vertically
        String result = "";
        for(int j=0;j<contain[0].length;j++){
            String subString="";
            for(int i=0;i<contain.length;i++){
                if((int)contain[i][j]==0){
                   continue;
                }
                else{
                    subString+=contain[i][j];
                }
            }
            result = result+subString+" ";
        }
        return result.trim();

    }

    private int[] Sqrt(String data) {
        //get the length of input string;
        int length = data.length();
        //get the sqrt of length;
        double mid=Math.sqrt(new Double(length));
        //get fit pairs of row and columns;
        int min = (int)mid;
        int max = min+1;
        if(min*min>=length){
            return new int[]{min, min};
        }
        else{
            if(min*max>=length){
                return new int[]{min, max};
            }
            else{
                return new int[]{max, max};
            }
        }
    }

    public static void main(String[] args){
        String test1 = "haveaniceday";
        String test2 = "feedthedog";
        String test3 = "chillout";
        String test4 = "ifmanwas" +
                "meanttos" +
                "tayonthe" +
                "groundgo" +
                "dwouldha" +
                "vegivenu" +
                "sroots";
        Ecryption solution= new Ecryption();
        System.out.println(solution.Ecryption(test1));
        System.out.println(solution.Ecryption(test2));
        System.out.println(solution.Ecryption(test3));
        System.out.println(solution.Ecryption(test4));
    }
}
