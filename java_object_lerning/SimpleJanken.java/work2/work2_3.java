package work2;

import java.util.Scanner;

/*クラス名:work2_2
 *概要:参加人数と各プレイヤーの名前とジャンケンの手を読み込む
 *作成者:K.Asakura
 *作成日:2024/06/28
 */
public class work2_3 {
	//Scannerクラスを設定
	static Scanner standardInput = new Scanner(System.in);
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

	/*関数名:main
	 *概要:参加人数と各プレイヤーの名前とジャンケンの手を読み込む
	 *引数:なし
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/06/28
	 */
	public static void main(String[] args) {
		//表示する回戦数を調整するために足される数を定数化
		final int ADJUST_VALUE = 1;
		//プレイヤーの人数を格納する変数を初期化して宣言
		int playerValue = 0;
		//2から5の正の整数を入力させる
		while (playerValue < 2 || playerValue > 5) {
			//プレイヤーの人数の入力を促す
			System.out.print("プレイヤーの人数:");
			//プレイヤーの人数を読み込んで代入
			playerValue = standardInput.nextInt();
			//2から5以外の整数が入力された場合
			if (playerValue < 2 || playerValue > 5) {
				//2から5の正の整数の入力を促す
				System.out.print("2から5の正の整数を入力してください");
			}
		}
		//プレイヤーの名前を格納する配列を生成
		String playerName[] = new String[playerValue];
		//プレイヤーの手を格納する配列を生成
		int playerHand[] = new int[playerValue];
		//各プレイヤーの名前を読み込む
		for (int i = 0; i < playerValue; i++) {
			//プレイヤーの名前の入力を促す
			System.out.print("プレイヤー" + (i + ADJUST_VALUE) + "の名前:");
			//各プレイヤーの名前を読み込んで代入
			playerName[i] = standardInput.next();
		}
		//各プレイヤーの手を読み込む
		for (int i = 0; i < playerValue; i++) {
			//0から2の整数を入力させる
			do {
				//プレイヤーの手の入力を促す
				System.out.print(playerName[i] + "さんの手:");
				//プレイヤーの手を読み込む
				playerHand[i] = standardInput.nextInt();
				//0から2以外の整数が入力された場合
				if (playerHand[i] < HAND_STONE || playerHand[i] > HAND_PAPER) {
					//0から2の整数の入力を促す
					System.out.print("2から5の正の整数を入力してください");
				}
				//0から2の整数が入力されるまでループ
			} while (playerHand[i] < HAND_STONE || playerHand[i] > HAND_PAPER);

		}
		//ジャンケンを開始したことを表示
		System.out.println("【ジャンケン開始】");
		//改行を出力
		System.out.println();
	}

}