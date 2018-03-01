package com.projectimagesgame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	Game game = new Game();
	Button buttons[] = new Button[16];
	int count = 0;
	int localCount[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	int index1 = -1, index2 = -1;
	TextView textView;
	String isMatchedString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView1);
        
        buttons[0] = (Button) findViewById(R.id.button1);
        buttons[0].setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				runGame(buttons[0], 0);
				
			}
		});
        
        buttons[1] = (Button) findViewById(R.id.button2);
        buttons[1].setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				runGame(buttons[1], 1);
				
			}
		});
        
        buttons[2] = (Button) findViewById(R.id.button3);
        buttons[2].setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				runGame(buttons[2], 2);
				
			}
		});
        
        buttons[3] = (Button) findViewById(R.id.button4);
        buttons[3].setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				runGame(buttons[3], 3);
				
			}
		});
        
        buttons[4] = (Button) findViewById(R.id.button5);
        buttons[4].setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				runGame(buttons[4], 4);
				
			}
		});
        
        buttons[5] = (Button) findViewById(R.id.button6);
        buttons[5].setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				runGame(buttons[5], 5);
				
			}
		});
        
        buttons[6] = (Button) findViewById(R.id.button7);
        buttons[6].setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				runGame(buttons[6], 6);
				
			}
		});
        
        buttons[7] = (Button) findViewById(R.id.button8);
        buttons[7].setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				runGame(buttons[7], 7);
				
			}
		});
        
        buttons[8] = (Button) findViewById(R.id.button9);
        buttons[8].setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				runGame(buttons[8], 8);
				
			}
		});
        
        buttons[9] = (Button) findViewById(R.id.button10);
        buttons[9].setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				runGame(buttons[9], 9);
				
			}
		});
        
        buttons[10] = (Button) findViewById(R.id.button11);
        buttons[10].setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				runGame(buttons[10], 10);
				
			}
		});
        
        buttons[11] = (Button) findViewById(R.id.button12);
        buttons[11].setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				runGame(buttons[11], 11);
				
			}
		});
        
        buttons[12] = (Button) findViewById(R.id.button13);
        buttons[12].setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				runGame(buttons[12], 12);
				
			}
		});
        
        buttons[13] = (Button) findViewById(R.id.button14);
        buttons[13].setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				runGame(buttons[13], 13);
				
			}
		});
        
        buttons[14] = (Button) findViewById(R.id.button15);
        buttons[14].setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				runGame(buttons[14], 14);
				
			}
		});
        
        buttons[15] = (Button) findViewById(R.id.button16);
        buttons[15].setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				runGame(buttons[15], 15);
				
			}
		});
    }
    
    public void runGame(Button button, int index) {
		localCount[index] += 1;
		button.setText(String.valueOf(game.getValueOfBox(index)));
		if(localCount[index] <= 1) {
			count += 1;
			if (count == 1) {
				index1 = index;
			}
			else if(count == 2) {
				index2 = index;
				if (game.checkMatched(index1, index2)) {
					game.gameScore(true);
					isMatchedString = "Matched!";
					
					if(game.isEnd()) {
						AlertDialog.Builder builder = new AlertDialog.Builder(this);
						builder.setMessage("Score: " + game.getScore())
							.setTitle("Congratulations!")
							.setCancelable(false)
							.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					           public void onClick(DialogInterface dialog, int id) {
					        	   resetGame();
					        	   textView.setText(String.valueOf(game.getScore()));
					           }
					       });
						AlertDialog alert = builder.create();
						alert.show();
					}
				}
				else
				{
					game.gameScore(false);
					isMatchedString = "Didn't match";
				}
				AlertDialog.Builder builder = new AlertDialog.Builder(this);
				builder.setMessage(isMatchedString)
			       .setCancelable(false)
			       .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			           public void onClick(DialogInterface dialog, int id) {
			        	   resetButtons();
						   resetCount();
			           }
			       });
				AlertDialog alert = builder.create();
				alert.show();
			}
		}
		textView.setText(String.valueOf(game.getScore()));
    }
    
    public void resetButtons() {
    	for (int i = 0; i < buttons.length; i++) {
    		if (!game.getSituationOfBox(i)) {
    			buttons[i].setText("");
			}
			else {
				buttons[i].setBackgroundColor(Color.GRAY);
			}
		}
    }
    
    public void resetGame() {
    	for (int i = 0; i < buttons.length; i++) {
    		buttons[i].setText("");
    		buttons[i].setBackgroundResource(R.drawable.design_kutu);
    	}
		game.resetGame();
    }
    
    public void resetCount() {
    	for (int i = 0; i < localCount.length; i++) {
			localCount[i] = 0;
		}
    	count = 0;
    }
    
}
