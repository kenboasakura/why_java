package work2;

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
	//グーの範囲を定数化
	public static final int STONE_RANGE = 1;
	//チョキの範囲を定数化
	public static final int SCISSORS_RANGE = 2;
	//パーの範囲を定数化
	public static final int PAPER_RANGE = 3;
	//ジャンケンの手の種類を定数化
	public static final int HAND_RANGE = 3;

	/*関数名:main
	 *概要:3回勝負のじゃんけんを行う
	 *引数:なし
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/06/28
	 */
	public static void main(String[] args) {
		//試合数を定数化
		final int GAME_COUNT = 3;
		//表示する回戦数を調整するために足される数を定数化
		final int ADJUST_VALUE = 1;
		//プレイヤー1の勝利数
		int firstPlayerWinCount = 0;
		//プレイヤー2の勝利数
		int secondPlayerWinCount = 0;
		//ジャンケンを開始したことを表示
		System.out.println("【ジャンケン開始】\n");
		//3回勝負のジャンケンを行う
		for (int countNumber = 0; countNumber < GAME_COUNT; countNumber++) {
			//ジャンケンを開始したことを表示
			System.out.println("【" + (countNumber + ADJUST_VALUE) + "回戦目】");
			//プレイヤー1の手を初期化
			int firstPlayerHand = 0;
			//ジャンケンの手をランダムに決定する変数を初期化
			double randomNumber = 0;
			//プレイヤーの手をランダムに得る
			randomNumber = Math.random() * HAND_RANGE;
			//グーの場合
			if (randomNumber < STONE_RANGE) {
				//プレイヤー1の手にグーを代入
				firstPlayerHand = HAND_STONE;
				//グーと表示
				System.out.print("グー");
				//チョキの場合
			} else if (randomNumber < SCISSORS_RANGE) {
				//プレイヤー1の手にチョキを代入
				firstPlayerHand = HAND_SCISSORS;
				//チョキと表示
				System.out.print("チョキ");
				//パーの場合
			} else if (randomNumber < PAPER_RANGE) {
				//プレイヤー1の手にチョキを代入
				firstPlayerHand = HAND_PAPER;
				//パーと表示
				System.out.print("パー");
			}

			//vsと表示
			System.out.print(" vs. ");

			//プレイヤー2の手を初期化
			int secondPlayerHand = 0;
			//プレイヤーの手をランダムに得る
			randomNumber = Math.random() * HAND_RANGE;
			//グーの場合
			if (randomNumber < STONE_RANGE) {
				//プレイヤー2の手にグーを代入
				secondPlayerHand = HAND_STONE;
				//グーと表示
				System.out.print("グー");
				//チョキの場合
			} else if (randomNumber < SCISSORS_RANGE) {
				//プレイヤー2の手にチョキを代入
				secondPlayerHand = HAND_SCISSORS;
				//チョキと表示
				System.out.print("チョキ");
				//パーの場合
			} else if (randomNumber < PAPER_RANGE) {
				//プレイヤー2の手にチョキを代入
				secondPlayerHand = HAND_PAPER;
				//パーと表示
				System.out.print("パー");
			}

			//プレイヤー1が勝ちの場合
			if (firstPlayerHand == HAND_STONE && secondPlayerHand == HAND_SCISSORS ||
					firstPlayerHand == HAND_SCISSORS && secondPlayerHand == HAND_PAPER ||
					firstPlayerHand == HAND_PAPER && secondPlayerHand == HAND_STONE) {
				//プレイヤー1の勝利数をカウント
				firstPlayerWinCount++;
				//プレイヤー1が勝ったことを表示
				System.out.println("\nプレイヤー1が勝ちました!\n");
				//プレイヤー2が勝ちの場合
			} else if (firstPlayerHand == HAND_STONE && secondPlayerHand == HAND_PAPER ||
					firstPlayerHand == HAND_SCISSORS && secondPlayerHand == HAND_STONE ||
					firstPlayerHand == HAND_PAPER && secondPlayerHand == HAND_SCISSORS) {
				//プレイヤー2の勝利数をカウント
				secondPlayerWinCount++;
				//プレイヤー2が勝ったことを表示
				System.out.println("\nプレイヤー2が勝ちました!\n");
				//引き分けの場合
			} else {
				//引き分けと表示
				System.out.println("\n引き分けです!\n");
			}
		}

		//ジャンケンを終了したことを表示
		System.out.println("【ジャンケン終了】\n");
		//プレイヤー1の勝利数が多い場合
		if (firstPlayerWinCount > secondPlayerWinCount) {
			//プレイヤー1が勝ちであることを表示
			System.out.println(firstPlayerWinCount + "対" + secondPlayerWinCount + "でプレイヤー1の勝ちです!\n");
			//プレイヤー2の勝利数が多い場合
		} else if (firstPlayerWinCount < secondPlayerWinCount) {
			//プレイヤー2が勝ちであることを表示
			System.out.println(firstPlayerWinCount + "対" + secondPlayerWinCount + "でプレイヤー2の勝ちです!\n");
			//引き分けの場合
		} else if (firstPlayerWinCount == secondPlayerWinCount) {
			//引き分けであることを表示
			System.out.println(firstPlayerWinCount + "対" + secondPlayerWinCount + "で引き分けです!\n");
		}

	}

}
