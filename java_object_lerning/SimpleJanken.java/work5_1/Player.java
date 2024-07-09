package work5_1;

/*クラス名:Player
 *概要:ジャンケンプレイヤーを管理
 *作成者:K.Asakura
 *作成日:2024/06/28
 */
public class Player implements Tactics {

	//プレイヤーの手グーを定数化
	public static final int HAND_STONE = 0;
	//プレイヤーの手チョキを定数化
	public static final int HAND_SCISSORS = 1;
	//プレイヤーの手パーを定数化
	public static final int HAND_PAPER = 2;
	//じゃんけんの手の種類を定数化
	public static final int HAND_RANGE = 3;
	//ランダムな小数がグーの場合の範囲を定数化
	public static final int STONE_RANGE = 1;
	//ランダムな小数がチョキの場合の範囲を定数化
	public static final int SCISSORS_RANGE = 2;
	//ランダムな小数がパーの場合の範囲を定数化
	public static final int PAPER_RANGE = 3;
	//Tactics型の戦略のフィールドを宣言
	private Tactics handTactics;
	//String型の名前のフィールドを宣言
	private String playerName;
	//int型の勝利回数のフィールドを初期化して宣言
	private int winCount = 0;

	/*コンストラクタ名:Player
	 *概要:プレイヤーの名前を仮引数で初期化
	 *引数:名前(String)
	 *作成者:K.Asakura
	 *作成日:2024/06/28
	 */
	public Player(String playerName) {
		//名前を仮引数で初期化
		this.playerName = playerName;
	}


	/*関数名:showHand
	 *概要:ジャンケンの手をランダムに決定
	 *引数:なし
	 *戻り値:ジャンケンの手(int)
	 *作成者:K.Asakura
	 *作成日:2024/06/28
	 */
	public int showHand() {
		//プレイヤーの手を格納する変数に戦略インタフェースを用いて代入
		int playerHand = readTactics();
		//プレイヤーの手を返却
		return playerHand;
	}

	/*関数名:notifyResoult
	 *概要:勝ったプレイヤーの勝利数を増加
	 *引数:勝負結果(boolean)
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/06/28
	 */
	public void notifyResoult(boolean resultValue) {
		//じゃんけんに勝った場合実行
		if (resultValue = true) {
			//勝利数を1増加
			winCount++;
		}
	}

	/*関数名:getWinCount
	 *概要:勝利数を返却
	 *引数:なし
	 *戻り値:勝利数(int)
	 *作成者:K.Asakura
	 *作成日:2024/06/28
	 */
	public int getWinCount() {
		//勝利数を返却
		return winCount;
	}

	/*関数名:getName
	 *概要:プレイヤーの名前を返却
	 *引数:名前(String)
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/06/28
	 */
	public String getName() {
		//名前を返却
		return playerName;
	}

	/*関数名:setTactics
	 *概要:戦略を仮引数で初期化
	 *引数:戦略(Tactics)
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/06/28
	 */
	public void setTactics(Tactics handTactics) {
		//戦略を仮引数で初期化
		this.handTactics = handTactics;
	}

	/*関数名:readTactics
	 *概要:戦略によって出された手を返却
	 *引数:なし
	 *戻り値:戦略によって出された手(int)
	 *作成者:K.Asakura
	 *作成日:2024/06/28
	 */
	public int readTactics() {
		//グーを返却
		return Player.HAND_STONE;
	}



	
}
