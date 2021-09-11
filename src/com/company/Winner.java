package com.company;

public class Winner {
        int indexWin = 0;
        public void WhoWin(int user, int pc, int size){
                indexWin = (size + user - pc) % size;
        }
        public String getWin(){
                if(indexWin==0)return "DRAW";
                else if(indexWin%2==1)return "You win!";
                else return "You lose!";
        }
        public String getWinforTable(Integer one, Integer two, Integer size){
                int index = (size + one - two) % size;
                if(index==0)return "DRAW";
                else if(index%2==1)return "WIN";
                else return "LOSE";
        }
}
