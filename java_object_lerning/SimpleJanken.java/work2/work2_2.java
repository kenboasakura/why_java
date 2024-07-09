package work2;
//Randomクラスのインポート
import java.util.Random;

/*クラス名:work2_2
 *概要:3回勝負のじゃんけんを行う
 *作成者:K.Asakura
 *作成日:2024/06/28
 */
public class work2_2 {
	//グーを定数化
	public static final int HAND_STONE = 0;
	//チョキを定数化
	public static final int HAND_SCISSORS = 1;
	//パーを定数化
	public static final int HAND_PAPER = 2;
	//ジャンケンの手の種類を定数化
	public static final int HAND_RANGE = 3;
	//勝利した場合を定数化
	public static final int GAME_WIN = 0;
	//敗北した場合を定数化
	public static final int GAME_LOSE = 1;
	//引き分けの場合を定数化
	public static final int GAME_DROW = 2;

	/*関数名:handView
	 *概要:ジャンケンの手を表示
	 *引数:ジャンケンの手(int)
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/06/28
	 */
	public static void handView(int handNumber) {
		//手によって飛び先を変更
		switch (handNumber) {
		//グーの場合
		case HAND_STONE:
			//グーと表示
			System.out.print("グー");
			//switch文を抜け出す
			break;
		//チョキの場合
		case HAND_SCISSORS:
			//チョキと表示
			System.out.print("チョキ");
			//switch文を抜け出す
			break;
		//パーの場合
		case HAND_PAPER:
			//パーと表示
			System.out.print("パー");
			//switch文を抜け出す
			break;
		}
	}

	/*関数名:handView
	 *概要:ジャンケンの勝ち負けを表す整数を返却
	 *引数:勝負結果(int)
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/06/28
	 */
	public static int gameJudge(int fistPlayerHand, int secondPlayerHand) {
		//勝敗を格納する変数を初期化して宣言
		int gameJudge = 0;
		//最初のプレイヤーが勝ちの場合
		if (fistPlayerHand == HAND_STONE && secondPlayerHand == HAND_SCISSORS ||
				fistPlayerHand == HAND_SCISSORS && secondPlayerHand == HAND_PAPER ||
				fistPlayerHand == HAND_PAPER && secondPlayerHand == HAND_STONE) {
			//勝ちを代入
			gameJudge = GAME_WIN;
			//最初のプレイヤーが負けの場合
		} else if (fistPlayerHand == HAND_STONE && secondPlayerHand == HAND_PAPER ||
				fistPlayerHand == HAND_SCISSORS && secondPlayerHand == HAND_STONE ||
				fistPlayerHand == HAND_PAPER && secondPlayerHand == HAND_SCISSORS) {
			//負けを代入
			gameJudge = GAME_LOSE;
			//引き分けの場合
		} else {
			//引き分けを代入
			gameJudge = GAME_DROW;
		}
		//勝負した結果を格納した変数を返却
		return gameJudge;
	}

	/*関数名:main
	 *概要:3回勝負のじゃんけんを行う
	 *引数:なし
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/06/28
	 */
	public static void main(String[] args) {
		//Randomクラスを設定
		Random randomNumber = new Random();
		//試合数を定数化
		final int GAME_COUNT = 3;
		//表示する回戦数を調整するために足される数を定数化
		final int ADJUST_VALUE = 1;
		//ジャンケンを開始したことを表示
		System.out.println("【ジャンケン開始】");
		//改行を出力
		System.out.println();
		//プレイヤー1の勝利数
		int firstPlayerWinCount = 0;
		//プレイヤー2の勝利数
		int secondPlayerWinCount = 0;
		for (int i = 0; i < GAME_COUNT; i++) {
			//ジャンケンを開始したことを表示
			System.out.println("【"+(i+ADJUST_VALUE)+"回戦目】");
			//プレイヤー1の手をランダムに決定
			int firstPlayerHand = randomNumber.nextInt(HAND_RANGE);
			//プレイヤー1の手を表示
			handView(firstPlayerHand);
			//vs.と表示
			System.out.print(" vs. ");
			//プレイヤー2の手をランダムに決定
			int secondPlayerHand = randomNumber.nextInt(HAND_RANGE);
			//プレイヤー2の手を表示
			handView(secondPlayerHand);
			//改行を出力
			System.out.println();
			//勝ち負けによって飛び先を変更
			switch (gameJudge(firstPlayerHand, secondPlayerHand)) {
			//プレイヤー1の勝ちの場合
			case GAME_WIN:
				//プレイヤー1の勝ちと表示
				System.out.println("プレイヤー1の勝ちです!");
				//プレイヤー1の勝利数を1増やす
				firstPlayerWinCount++;
				//switch文を抜け出す
				break;
			//プレイヤー2の勝ちの場合
			case GAME_LOSE:
				//プレイヤー2の勝ちと表示
				System.out.println("プレイヤー2の勝ちです!");
				//プレイヤー2の勝利数を1増やす
				secondPlayerWinCount++;
				//switch文を抜け出す
				break;
			//引き分けの場合
			case GAME_DROW:
				//引き分けと表示
				System.out.println("引き分けです。");
				//switch文を抜け出す
				break;
			}
			//改行を出力
			System.out.println();
		}
		//ジャンケンを終了したことを表示
		System.out.println("\n【ジャンケン終了】\n");
		//プレイヤー1の勝利数が多い場合
		if (firstPlayerWinCount > secondPlayerWinCount) {
			//プレイヤー1の勝ちと表示
			System.out.println(firstPlayerWinCount+"対"+secondPlayerWinCount+"でプレイヤー1の勝ちです!");
			//プレイヤー2の勝利数が多い場合
		} else if (firstPlayerWinCount < secondPlayerWinCount) {
			//プレイヤー2の勝ちと表示
			System.out.println(firstPlayerWinCount+"対"+secondPlayerWinCount+"でプレイヤー2の勝ちです!");
			//プレイヤー1と2の勝利数が同じ場合
		} else {
			//引き分けと表示
			System.out.println("引き分けです。");
		}

	}

}
