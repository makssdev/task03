package com.company;

import com.github.freva.asciitable.AsciiTable;

public class Table {

  public void GenerateTable(String[] args){
    String[] headers = new String[args.length+1]; headers[0]="USER\\PC";
    String[][] data = new String[args.length][args.length+1];
    Winner tabWin =  new Winner();

    for(int i=0;i< args.length;i++)data[i][0]=args[i];
    for(int i=0;i<args.length;i++){
      headers[i+1]=args[i];
        for(int j=1; j< args.length+1; j++){
          data[i][j] = tabWin.getWinforTable(i,j-1, args.length);
        }
    }
    System.out.println(AsciiTable.getTable(headers, data));
  }
}
