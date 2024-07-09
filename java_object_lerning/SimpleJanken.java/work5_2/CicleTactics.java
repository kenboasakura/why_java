package work5_2;

/*クラス名:CicleTactics
 *概要:ジャンケンの手を戦略的に管理
 *作成者:K.Asakura
 *作成日:2024/06/28
 */
public class CicleTactics implements Tactics {
	//プレイヤーの手グーを定数化
	public static final int HAND_STONE = 0;
	//プレイヤーの手チョキを定数化
	public static final int HAND_SCISSORS = 1;
	//プレイヤーの手パーを定数化
	public static final int HAND_PAPER = 2;
	private int tacticsCount = 0;
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
	public CicleTactics(String playerName) {
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

	/*関数名:readTactics
	 *概要:グーチョキパーの順にジャンケンの手を出す
	 *引数:なし
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/06/28
	 */
	public int readTactics() {
		//パーを出した次がグーを出す処理
		tacticsCount = tacticsCount > HAND_PAPER ? HAND_STONE: tacticsCount;
		//プレイヤーの手を格納する変数グーチョキパーを順番に代入
		int playerHand = tacticsCount;
		//次ぎだす手を決定
		tacticsCount++;
		//プレイヤーの手を返却
		return playerHand;
	}

}
