package work3_3;

//Playerクラスをインポート
import work3_2.Player;

/*クラス名:Judge
 *概要:ジャンケンの勝負を管理
 *作成者:K.Asakura
 *作成日:2024/06/28
 */
public class Judge {
	//勝負回数を定数化
	static final int MATCH_COUNT = 3;

	/*関数名:startJanken
	 *概要:3回勝負のじゃんけんを行う
	 *引数:2人のプレイヤー(Playerクラス)
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/06/28
	 */
	public void startJanken(Player firstPlayer, Player secondPlayer) {
		//試合回数表示する数を調整するために足される整数を定数化
		final int ADJUSTMENT_VALUE = 1;
		//じゃんけんの開始を宣言
		System.out.println("【ジャンケン開始】\n");
		//ジャンケンを3回行う
		for (int i = 0; i < MATCH_COUNT; i++) { //回戦目を表示
			//じゃんけんの開始を宣言
			System.out.println("【" + (i + ADJUSTMENT_VALUE) + "回戦目】\n");
			//声かけを表示
			System.out.println("ジャンケン・ポン\n");
			//どちらが勝ちかを判定
			Player winnerPlayer = judgeJanken(firstPlayer, secondPlayer);
			//勝者がいる場合
			if (winnerPlayer != null) {
				//勝利者を表示
				System.out.println("\n" + winnerPlayer.getName() + "が勝ちました!\n");
				//勝利者の勝利数をメソッドを呼び出して増加
				winnerPlayer.notifyResoult(true);
				//引き分けの場合
			} else {
				//引き分けであることを表示
				System.out.println("引き分けです\n");
			}
		}
		//ジャンケンの終了を宣言する
		System.out.println("【ジャンケンを終了】\n");
		//最終的な勝者を選定
		Player finalWinner = judgeFinalWinner(firstPlayer, secondPlayer);
		//勝利数を表示
		System.out.print(firstPlayer.getWinCount() + "対" + secondPlayer.getWinCount() + "で");
		//勝者がいる場合
		if (finalWinner != null) {
			//勝者を表示
			System.out.println(finalWinner.getName() + "の勝ちです!\n");
			//引き分けの場合
		} else {
			//引き分けであることを表示
			System.out.println("引き分けです\n");
		}
	}
	
	/*関数名:judgeJanken
	 *概要:ジャンケンの勝ち負けを判定して勝者を返却
	 *引数:2人のプレイヤー(Playerクラス)
	 *戻り値:勝者(Playerクラス)
	 *作成者:K.Asakura
	 *作成日:2024/06/28
	 */
	private Player judgeJanken(Player firstPlayer, Player secondPlayer) {
		//勝利者を規定値で初期化し宣言
		Player winnerPlayer = null;
		//プレイヤー1の手にメソッドを用いて代入
		int firstPlayerHand = firstPlayer.showHand();
		//プレイヤー1の手を表示
		printHand(firstPlayerHand);
		//VS.を表示
		System.out.println(" VS.");
		//プレイヤー2の手にメソッドを用いて代入
		int secondPlayerHand = secondPlayer.showHand();
		//プレイヤー2の手を表示
		printHand(secondPlayerHand);
		//プレイヤー1の勝ちの場合
		if (firstPlayerHand == Player.HAND_STONE && secondPlayerHand == Player.HAND_SCISSORS ||
				firstPlayerHand == Player.HAND_SCISSORS && secondPlayerHand == Player.HAND_PAPER ||
				firstPlayerHand == Player.HAND_PAPER && secondPlayerHand == Player.HAND_STONE) {
			//勝利者にプレイヤー1を代入
			winnerPlayer = firstPlayer;
			//プレイヤー2の勝ちの場合
		} else if (firstPlayerHand == Player.HAND_STONE && secondPlayerHand == Player.HAND_PAPER ||
				firstPlayerHand == Player.HAND_SCISSORS && secondPlayerHand == Player.HAND_STONE ||
				firstPlayerHand == Player.HAND_PAPER && secondPlayerHand == Player.HAND_SCISSORS) {
			//勝利者にプレイヤー2を代入
			winnerPlayer = secondPlayer;
		}
		//勝利者を返却
		return winnerPlayer;
	}

	/*関数名:judgeFinalWinner
	 *概要:最終的なジャンケンの勝者を判定し勝者を返却
	 *引数:2人のプレイヤー(Playerクラス)
	 *戻り値:勝者(Playerクラス)
	 *作成者:K.Asakura
	 *作成日:2024/06/28
	 */
	private Player judgeFinalWinner(Player firstPlayer, Player secondPlayer) {
		//勝利者を規定値で初期化し宣言
		Player winnerPlayer = null;
		//プレイヤー1の勝利数をメソッドを用いて代入
		int firstPlayerWinCount = firstPlayer.getWinCount();
		//プレイヤー2の勝利数をメソッドを用いて代入
		int secondPlayerrWinCount = secondPlayer.getWinCount();
		//プレイヤー1の勝利数が多い場合
		if (firstPlayerWinCount > secondPlayerrWinCount) {
			//勝利者にプレイヤー1を代入
			winnerPlayer = firstPlayer;
			//プレイヤー2の勝利数が多い場合
		} else if (secondPlayerrWinCount > firstPlayerWinCount) {
			//勝利者にプレイヤー2を代入
			winnerPlayer = secondPlayer;
		}
		//勝利者を返却
		return winnerPlayer;
	}

	/*関数名:printHand
	 *概要:ジャンケンの手を表示
	 *引数:ジャンケンの手(int)
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/06/28
	 */
	private void printHand(int playerHand) {
		//ジャンケンの手によって飛び先を変更
		switch (playerHand) {
		//グーの場合
		case Player.HAND_STONE:
			//グーと表示
			System.out.println("グー");
			//switch文を抜け出る
			break;
		//チョキの場合
		case Player.HAND_SCISSORS:
			//グーと表示
			System.out.println("チョキ");
			//switch文を抜け出る
			break;
		//パーの場合
		case Player.HAND_PAPER:
			//グーと表示
			System.out.println("パー");
			//switch文を抜け出る
			break;
		//値がない場合
		default:
			//switch文を抜け出る
			break;
		}
	}
}
