package searching;

public class LinearSearch {
    //Linear search method
    public static int linearSearch(int[] array, int elementToSearch){
        for(int i = 0; i < array.length; i++){
            if(array[i] == elementToSearch){
                return i;
            }
        }
        return -1;

    }
    //Main class
    public static void main(String[] args) {
        int[] marks = {12,12,45,67,68,37,48,86,37,58};
        int elementToSearch = 13;
        int searchResults = linearSearch(marks,elementToSearch);

        if(searchResults!= -1){
            System.out.println("Element '" + elementToSearch + "' found at index :" + searchResults);
        }
        else{
            System.out.println("Element '" + elementToSearch + "' not found.");
        }


    }
}
