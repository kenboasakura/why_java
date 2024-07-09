package work7_3;

//ArrayListクラスをインポート
import java.util.ArrayList;

/*クラス名:Hand
 *概要:手札を管理
 *作成者:K.Asakura
 *作成日:2024/07/02
 */
public class Hand {
	//先頭のインデックスを定数化
	public static final int INDEX_NUMBER_ZERO = 0;
	//2番目のインデックスを定数化
	public static final int INDEX_NUMBER_ONE = 1;

	//手札を保持するためのリスト
	private ArrayList myHand = new ArrayList();

	/*関数名:addCard
	 *概要:カードを加える
	 *引数:引いたカード(Cardクラス)
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/07/02
	 */
	public void addCard(Card drawCard) {
		//カードを追加
		getMyHand().add(drawCard);
	}

	/*関数名:pickCard
	 *概要:引いたカードを返却する
	 *引数:なし
	 *戻り値:引いたカード(Cardクラス)
	 *作成者:K.Asakura
	 *作成日:2024/07/02
	 */
	public Card pickCard() {
		//カードを引く
		Card pickedCard = (Card) getMyHand().remove(0);
		//引いたカードを返却
		return pickedCard;
	}

	/*関数名:shuffleCard
	 *概要:カードをシャッフルする
	 *引数:なし
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/07/02
	 */
	public void shuffleCard() {
		//繰り返す数を求めるため乗算に使う整数を定数化
		final int REPEAT_COUNT = 2;
		//手札の枚数を数える
		int handValue = getMyHand().size();
		//カードを抜き出す位置を初期化して宣言
		int posCard = 0;
		//ランダムにカードを抜き取って最後に加える動作を繰り返す
		for (int i = 0; i < handValue * REPEAT_COUNT; i++) {
			//ランダムな位置を決定
			posCard = (int) (Math.random() * handValue);
			//決定した位置からカードを抜き取る
			Card pickedCard = (Card) getMyHand().remove(posCard);
			//抜き取ったカードを加える
			getMyHand().add(pickedCard);
		}
	}

	/*関数名:getNumberOfCards
	 *概要:手札の枚数を数える
	 *引数:なし
	 *戻り値:数えた手札の枚数(int)
	 *作成者:K.Asakura
	 *作成日:2024/07/02
	 */
	public int getNumberOfCards() {
		//手札の枚数を返却
		return getMyHand().size();
	}

	/*関数名:toString
	 *概要:手札の情報を返却
	 *引数:なし
	 *戻り値:自分の手札全ての情報(Srting)
	 *作成者:K.Asakura
	 *作成日:2024/07/02
	 */
	public String toString() {
		//文字列を格納するためのインスタンスを生成
		StringBuffer string = new StringBuffer();
		//自分の手札の枚数で初期化して宣言
		int handSize = getMyHand().size();
		//手札がある場合
		if (handSize > 0) {
			//手札の枚数分カードを表示
			for (int i = 0; i < handSize; i++) {
				//カード情報を取得
				Card myCard = (Card) getMyHand().get(i);
				//カード情報を取得
				string.append(myCard);
				//空白を出力
				string.append(" ");
			}
		}
		//文字列表現を返却
		return string.toString();
	}

	/*関数名:getMyHand
	 *概要:手札を取得する
	 *引数:なし
	 *戻り値:自分の手札(ArrayList)
	 *作成者:K.Asakura
	 *作成日:2024/07/02
	 */
	public ArrayList getMyHand() {
		//自分の手札を返却
		return myHand;
	}

	/*関数名:setMyHand
	 *概要:自分の手札を設定する
	 *引数:自分の手札(ArrayList)
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/07/02
	 */
	public void setMyHand(ArrayList myHand) {
		//仮引数で自分の手札を設定する
		this.myHand = myHand;
	}

}
