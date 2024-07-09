package work5_2;

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
	 *引数:2人のプレイヤー(CicleTacticsクラス)
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/06/28
	 */
	public void startJanken(CicleTactics firstCicleTactics, CicleTactics secondCicleTactics) {
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
			CicleTactics winnerCicleTactics = judgeJanken(firstCicleTactics, secondCicleTactics);
			//勝者がいる場合
			if (winnerCicleTactics != null) {
				//勝利者を表示
				System.out.println("\n" + winnerCicleTactics.getName() + "が勝ちました!\n");
				//勝利者の勝利数をメソッドを呼び出して増加
				winnerCicleTactics.notifyResoult(true);
				//引き分けの場合
			} else {
				//引き分けであることを表示
				System.out.println("引き分けです\n");
			}
		}
		//ジャンケンの終了を宣言する
		System.out.println("【ジャンケンを終了】\n");
		//最終的な勝者を選定
		CicleTactics finalWinner = judgeFinalWinner(firstCicleTactics, secondCicleTactics);
		//勝利数を表示
		System.out.print(firstCicleTactics.getWinCount() + "対" + secondCicleTactics.getWinCount() + "で");
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
	 *引数:2人のプレイヤー(CicleTacticsクラス)
	 *戻り値:勝者(CicleTacticsクラス)
	 *作成者:K.Asakura
	 *作成日:2024/06/28
	 */
	private CicleTactics judgeJanken(CicleTactics firstCicleTactics, CicleTactics secondCicleTactics) {
		//勝利者を規定値で初期化し宣言
		CicleTactics winnerCicleTactics = null;
		//プレイヤー1の手にメソッドを用いて代入
		int firstCicleTacticsHand = firstCicleTactics.showHand();
		//プレイヤー1の手を表示
		printHand(firstCicleTacticsHand);
		//VS.を表示
		System.out.println(" VS.");
		//プレイヤー2の手にメソッドを用いて代入
		int secondCicleTacticsHand = secondCicleTactics.showHand();
		//プレイヤー2の手を表示
		printHand(secondCicleTacticsHand);
		//プレイヤー1の勝ちの場合
		if (firstCicleTacticsHand == CicleTactics.HAND_STONE && secondCicleTacticsHand == CicleTactics.HAND_SCISSORS ||
				firstCicleTacticsHand == CicleTactics.HAND_SCISSORS && secondCicleTacticsHand == CicleTactics.HAND_PAPER ||
				firstCicleTacticsHand == CicleTactics.HAND_PAPER && secondCicleTacticsHand == CicleTactics.HAND_STONE) {
			//勝利者にプレイヤー1を代入
			winnerCicleTactics = firstCicleTactics;
			//プレイヤー2の勝ちの場合
		} else if (firstCicleTacticsHand == CicleTactics.HAND_STONE && secondCicleTacticsHand == CicleTactics.HAND_PAPER ||
				firstCicleTacticsHand == CicleTactics.HAND_SCISSORS && secondCicleTacticsHand == CicleTactics.HAND_STONE ||
				firstCicleTacticsHand == CicleTactics.HAND_PAPER && secondCicleTacticsHand == CicleTactics.HAND_SCISSORS) {
			//勝利者にプレイヤー2を代入
			winnerCicleTactics = secondCicleTactics;
		}
		//勝利者を返却
		return winnerCicleTactics;
	}

	/*関数名:judgeFinalWinner
	 *概要:最終的なジャンケンの勝者を判定し勝者を返却
	 *引数:2人のプレイヤー(CicleTacticsクラス)
	 *戻り値:勝者(CicleTacticsクラス)
	 *作成者:K.Asakura
	 *作成日:2024/06/28
	 */
	private CicleTactics judgeFinalWinner(CicleTactics firstCicleTactics, CicleTactics secondCicleTactics) {
		//勝利者を規定値で初期化し宣言
		CicleTactics winnerCicleTactics = null;
		//プレイヤー1の勝利数をメソッドを用いて代入
		int firstCicleTacticsWinCount = firstCicleTactics.getWinCount();
		//プレイヤー2の勝利数をメソッドを用いて代入
		int secondCicleTacticsrWinCount = secondCicleTactics.getWinCount();
		//プレイヤー1の勝利数が多い場合
		if (firstCicleTacticsWinCount > secondCicleTacticsrWinCount) {
			//勝利者にプレイヤー1を代入
			winnerCicleTactics = firstCicleTactics;
			//プレイヤー2の勝利数が多い場合
		} else if (secondCicleTacticsrWinCount > firstCicleTacticsWinCount) {
			//勝利者にプレイヤー2を代入
			winnerCicleTactics = secondCicleTactics;
		}
		//勝利者を返却
		return winnerCicleTactics;
	}

	/*関数名:printHand
	 *概要:ジャンケンの手を表示
	 *引数:ジャンケンの手(int)
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/06/28
	 */
	private void printHand(int CicleTacticsHand) {
		//ジャンケンの手によって飛び先を変更
		switch (CicleTacticsHand) {
		//グーの場合
		case CicleTactics.HAND_STONE:
			//グーと表示
			System.out.println("グー");
			//switch文を抜け出る
			break;
		//チョキの場合
		case CicleTactics.HAND_SCISSORS:
			//グーと表示
			System.out.println("チョキ");
			//switch文を抜け出る
			break;
		//パーの場合
		case CicleTactics.HAND_PAPER:
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
