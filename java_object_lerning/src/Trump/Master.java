package Trump;
//ArrayListクラスをインポート
import java.util.ArrayList;

/*クラス名:Master
 *概要:進行役を管理
 *作成者:K.Asakura
 *作成日:2024/07/03
 */
public class Master {
	//敗者を定数化
	private static final int GAME_LOSER = 1; 
	//プレイヤーのリストを管理するフィールドを宣言
	private ArrayList playerList = new ArrayList();

	/*関数名:prepareGame
	 *概要:ゲームの準備をする
	 *引数:進行役のトランプ(Hand)
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public void prepareGame(Hand masterCard) {
		//カードを配ることを表示
		System.out.println("【カードを配ります】");
		//トランプをシャッフルする
		masterCard.shuffleCard();
		//トランプの枚数を取得
		int numberOfCards = masterCard.getNumberOfCards();
		//プレイヤーの人数を取得
		int numberOfPlayers = playerList.size();
		//各プレイヤーにカードを配る
		for (int i = 0; i < numberOfCards; i++) {
			//カードから1枚引く
			Card deckCard = masterCard.pickCard(0);
			//プレイヤーの数で均等に枚数を割る
			Player gamePlayer = (Player) playerList.get(i % numberOfPlayers);
			//プレイヤーはカードを受け取る
			gamePlayer.receiveCard(deckCard);
		}
	}

	/*関数名:startGame
	 *概要:ゲームの開始
	 *引数:なし
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public void startGame() {
		//次の順番を表すために足す数を定数化
		final int NEXT_ORDER = 1;
		//ゲームの開始を宣言
		System.out.println("\n【ゲームを開始します】");
		//プレイヤーの人数を取得
		for (int indexNumber = 0; playerList.size() > GAME_LOSER; indexNumber++) {
			//指名する順番を表す変数を宣言
			int playerIndex = indexNumber % playerList.size();
			//次に指名する順番を表す変数を宣言
			int nextPlayerIndex = (indexNumber + NEXT_ORDER) % playerList.size();
			//指名するプレイヤーの取得
			Player gamePlayer = (Player) playerList.get(playerIndex);
			//次のプレイヤーの取得
			Player nextPlayer = (Player) playerList.get(nextPlayerIndex);
			//指名されたプレイヤーを表示
			System.out.println("\n" + gamePlayer + "さんの番です");
			//次のプレイヤーを指名
			gamePlayer.playGame(nextPlayer);
		}
		//ゲームの終了を宣言
		System.out.println("【ゲームを終了しました】");
	}

	/*関数名:declareWin
	 *概要:上がったプレイヤーを除外
	 *引数:上がったプレイヤー(Player)
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public void declareWin(Player winnerPlayer) {
		//上がったプレイヤーを表示
		System.out.println("\n" + winnerPlayer + "さんが上がりました!");
		//上がったプレイヤーを除外
		deregisterPlayer(winnerPlayer);
	}

	/*関数名:reghsterPlayer
	 *概要:プレイヤーリストに参加者を追加
	 *引数:参加するプレイヤー(Player)
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public void registerPlayer(Player gamePlayer) {
		//プレイヤーリストに参加者を追加
		playerList.add(gamePlayer);
	}

	/*関数名:deregisterPlayer
	 *概要:プレイヤーリストから参加者を除外
	 *引数:参加しているプレイヤー(Player)
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public void deregisterPlayer(Player gamePlayer) {
		//プレイヤーリストの最後に残ったプレイヤーを定数化
		final int FINAL_PLAYER = 0;
		//プレイヤーリストから参加者を除外
		playerList.remove(gamePlayer);
		//残り一人になった場合
		if(playerList.size() == GAME_LOSER) {
			//敗者を取得
			Player defeatPlayer = (Player) playerList.get(FINAL_PLAYER);
			//敗者を表示
			System.out.println("\n" + defeatPlayer + "さんの負けです");
		}
	}

}
