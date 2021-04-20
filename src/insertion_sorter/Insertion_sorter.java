



package insertion_sorter;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Insertion_sorter extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        String empty_array_list="Empty Array List";
        
//                                SETUP TEXT FIELD
        TextField array_input=new TextField();
        array_input.setAlignment(Pos.CENTER);
        array_input.setMaxWidth(250);
        array_input.setPromptText("--Click Here to Type--");
        array_input.setFocusTraversable(false);
        
//                                SETUP BUTTONS
        Button add_string_btn=new Button("ADD");
        Button sort_btn = new Button("SORT");
        Button clear_btn=new Button("CLEAR");
        
//                                SETUP LABELS
        Label array_input_print=new Label(empty_array_list);
        array_input_print.setMaxWidth(400);
        array_input_print.setAlignment(Pos.CENTER);
        
        Label sorted_array_list=new Label();
        sorted_array_list.setMaxWidth(400);
        sorted_array_list.setAlignment(Pos.CENTER);
        
//                                SETUP ARRAY LIST
        ArrayList<String> array_list=new ArrayList();
        ObjectInsertionSorter sorter_class=new ObjectInsertionSorter();
        
//                                SETUP VBOX
        VBox vbox=new VBox(array_input, add_string_btn, array_input_print, 
                            sort_btn, sorted_array_list, clear_btn);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(15);
        Scene scene = new Scene(vbox, 500, 450);
        scene.getStylesheets().add("styles.css");
        
//                                SETUP KEY ENTER EVENT
        scene.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                if (array_input.getText().equals("")){                                  //if text field is empty, error
                array_input_print.setText("Eneter Something");
                array_input_print.setStyle("-fx-background-color: red;"
                                            + "-fx-padding: 10px;");
                array_input_print.setMaxWidth(200);
                }
                else {
                    array_list.add(array_input.getText());                              //add value of text field to array_input list
                    array_input.clear();                                                //clear text field
                    String string_array_list=sorter_class.printArrayList(array_list);   //use printArrayList method to convert array list to a string
                    array_input_print.setText(string_array_list);                       //set label to array list
                    array_input_print.setStyle("");                                     //reset styling from style sheet
                    array_input_print.setMaxWidth(400);                                 //reset max width to 400
                }
            }
        });
        
//                                    SETUP ADD STRING BUTTON LAMBDA EVENT
        add_string_btn.setOnAction(event ->{
            
            if (array_input.getText().equals("")){                                      //if array list is empty, error
                array_input_print.setText("Eneter Something");
                array_input_print.setStyle("-fx-background-color: red");
                array_input.requestFocus();
                array_input_print.setStyle("-fx-background-color: red;"
                                            + "-fx-padding: 10px;");
                array_input_print.setMaxWidth(200);
            }
            else {
                array_list.add(array_input.getText());                                  //add value of text field to array_input list
                array_input.clear();                                                    //clear text field
                String string_array_list=sorter_class.printArrayList(array_list);       //use printArrayList method to convert array list to a string
                array_input_print.setText(string_array_list);                           //set label to array list
                array_input_print.setStyle("");                                         //reset styling from style sheet
                array_input.requestFocus();                                             //request focus to keep cursor blinking and active for text field
                array_input_print.setMaxWidth(400);                                     //reset max width to 400
            }
        });
        
//                                    SETUP SORT BUTTON LAMBDA EVENT
        sort_btn.setOnAction(event ->{
            ArrayList<String> array=sorter_class.insertionSort(array_list);                                     //call insertionSort method to sort array list
            String string_array_list_sorted=sorter_class.printArrayList(array);    //use printArrayList method to convert array list to a string
            sorted_array_list.setText(string_array_list_sorted);                        //set label to array list
        });
        
//                                    SETUP CLEAR BUTTON LAMBDA EVENT
        clear_btn.setOnAction(event ->{
            array_input.clear();                                                    //clear text field
            sorted_array_list.setText("");                                          //clear label
            array_input_print.setText(empty_array_list);                            //reset prompt value for text field
            
            while (!array_list.isEmpty()){                                          //empty out array list
                array_list.remove(0);
            }
        });
    
        primaryStage.setTitle("Insertion Sort");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
