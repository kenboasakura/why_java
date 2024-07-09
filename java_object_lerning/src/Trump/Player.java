package Trump;

/*クラス名:Player
 *概要:プレイヤーを表す抽象クラス
 *作成者:K.Asakura
 *作成日:2024/07/03
 */
public abstract class Player {
	//プレイヤーの名前を表すString型のフィールドを宣言
	protected String plyerName;
	//試合中のテーブルを表すTable型のフィールドを宣言
	protected Table gameTable;
	//手札を表すString型のフィールドのインスタンスを生成
	protected Hand myHand = new Hand();
	//進行役を表すString型のフィールドを宣言
	protected Master gameMaster;
	//ルールを表すRule型のフィールドを宣言
	protected Rule gameRule;
	
	/*コンストラクタ名:Player
	 *概要:プレイヤーを管理するフィールドを仮引数で初期化
	 *引数:名前(String)、進行役(Master)、試合中のテーブル(Table)、トランプのルール(Rule)
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public Player(String plyerName,Master gameMaster,Table gameTable,Rule gameRule) {
		//名前を表すフィールドを仮引数で初期化
		this.plyerName = plyerName;
		//進行役を表すフィールドを仮引数で初期化
		this.gameMaster = gameMaster;
		//試合中のテーブルを表すフィールドを仮引数で初期化
		this.gameTable = gameTable;
		//ルールを表すフィールドを仮引数で初期化
		this.gameRule = gameRule;
	}
	
	/*関数名:playGame
	 *概要:順番を指名する抽象メソッド
	 *引数:次のプレイヤー(Player)
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public abstract void playGame(Player nextPlayer) ;
	
	/*関数名:receiveCard
	 *概要:受け取ったカードを手札に加える
	 *引数:受け取ったカード(Card)
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public void receiveCard(Card playerCard) {
		//受け取ったカードを手札に加える
		myHand.addCard(playerCard);
	}
	
	/*関数名:toString
	 *概要:プレイヤーの名前を返却する
	 *引数:なし
	 *戻り値:プレイヤーの名前(String)
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public String toString() {
		//プレイヤーの名前を返却
		return plyerName;
	}
	
	
}
