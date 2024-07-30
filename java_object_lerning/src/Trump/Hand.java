package Trump;
//ArrayListクラスをインポート
import java.util.ArrayList;

/*クラス名:Hand
 *概要:手札を管理
 *作成者:K.Asakura
 *作成日:2024/07/03
 */
public class Hand {

	//手札を保持するためのリスト
	private ArrayList<Card> myHand = new ArrayList<Card>();

	/*関数名:addCard
	 *概要:カードを加える
	 *引数:引いたカード(Cardクラス)
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public void addCard(Card drawCard) {
		//カードを追加
		myHand.add(drawCard);
	}

	/*関数名:lookCard
	 *概要:カードを見る
	 *引数:カードのポジション(int)
	 *戻り値:見ているカード(Cardクラス)
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public Card lookCard(int cardPosition) {
		//見ているカードを規定値で初期化して宣言
		Card lookCard = null;
		//指定されたポジションが適正である場合
		if ((0 <= cardPosition) && (cardPosition < myHand.size())) {
			//指定されたポジションのカードを取得し代入
			lookCard =  (Card) myHand.get(cardPosition);
		}
		//見ているカードを返却
		return lookCard;
	}

	/*関数名:pickCard
	 *概要:カードを引く
	 *引数:カードのポジション(int)
	 *戻り値:引いたカード(Cardクラス)
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public Card pickCard(int cardPosition) {
		//見ているカードを規定値で初期化して宣言
		Card pickedCard = null;
		//指定されたポジションが適正である場合
		if ((0 <= cardPosition) && (cardPosition < myHand.size())) {
			//指定されたポジションのカードを除外
			pickedCard = (Card) myHand.remove(cardPosition);
		}
		//引いたカードを返却
		return pickedCard;
	}

	/*関数名:shuffleCard
	 *概要:カードをシャッフルする
	 *引数:なし
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public void shuffleCard() {
		//繰り返す数を求めるため乗算に使う整数を定数化
		final int REPEAT_COUNT = 2;
		//手札の枚数を取得して初期化
		int handNumber = myHand.size();
		//カードを抜き出す位置を表す変数を初期化して宣言
		int cardPosition = 0;
		//ランダムにカードを抜き取って最後に加える動作を繰り返す
		for (int i = 0; i < handNumber * REPEAT_COUNT; i++) {
			//ランダムな位置を決定
			cardPosition = (int) (Math.random() * handNumber);
			//決定した位置からカードを抜き取る
			Card pickedCard = (Card) myHand.remove(cardPosition);
			//抜き取ったカードを加える
			myHand.add(pickedCard);
		}
	}

	/*関数名:getNumberOfCards
	 *概要:手札の枚数を数える
	 *引数:なし
	 *戻り値:数えた手札の枚数(int)
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public int getNumberOfCards() {
		//手札の枚数を返却
		return myHand.size();
	}

	/*関数名:toString
	 *概要:カード情報の文字列を返却
	 *引数:なし
	 *戻り値:カード情報の文字列(String)
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public String toString() {
		//文字列を格納するためのインスタンスを生成
		StringBuffer cardString = new StringBuffer();
		//手札の枚数を表す変数を自分の手札の枚数で初期化して宣言
		int handSize = myHand.size();
		//手札がある場合
		if (handSize > 0) {
			//手札のカードの文字列表現を表示
			for (int i = 0; i < handSize; i++) {
				//自分のカードを取得
				Card handCard = (Card) myHand.get(i);
				//カード情報を表示
				cardString.append(handCard);
				//スペースを出力
				cardString.append(" ");
			}
		}
		//カード情報の文字列表現を返却
		return cardString.toString();
	}

}
