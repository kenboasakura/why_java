package work7_2;

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
		myHand.add(drawCard);
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
		Card pickedCard = (Card) myHand.remove(0);
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
		int handValue = myHand.size();
		//カードを抜き出す位置を初期化して宣言
		int posCard = 0;
		//ランダムにカードを抜き取って最後に加える動作を繰り返す
		for (int i = 0; i < handValue * REPEAT_COUNT; i++) {
			//ランダムな位置を決定
			posCard = (int) (Math.random() * handValue);
			//決定した位置からカードを抜き取る
			Card pickedCard = (Card) myHand.remove(posCard);
			//抜き取ったカードを加える
			myHand.add(pickedCard);
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
		return myHand.size();
	}

	/*関数名:main
	 *概要:同じカードを探して返却する
	 *引数:なし
	 *戻り値:同じカード(Cardクラス型配列)
	 *作成者:K.Asakura
	 *作成日:2024/07/02
	 */
	public Card[] findSameNumberCard() {
		//カード1組分を定数化
		final int PAIR_CARDS = 2;
		//末尾のインデックスを調整するため引かれる整数を定数化
		final int ADJUSTMENT_INDEX = -1;
		//手札の枚数を自分の手札の枚数で初期化して宣言
		int numberOfCards = myHand.size();
		//同じカードを格納する配列を規定値で宣言
		Card[] sameCards = null;
		//カードがある場合
		if (numberOfCards > 0) {
			//末尾のインデックスを最後に追加されたカードで初期化して宣言
			int lastIndex = numberOfCards + ADJUSTMENT_INDEX;
			//最後に加えられたカードを取得
			Card lastAddedCard = (Card) myHand.get(lastIndex);
			//最後に加えられたカード番号を取得
			int lastAddedCardNumber = lastAddedCard.getNumber();
			//同じカード番号を探す
			for (int i = 0; i < lastIndex; i++) {
				//自分の手札を取得
				Card myCard = (Card) myHand.get(i);
				//同じカードを除外
				if (myCard.getNumber() == lastAddedCardNumber) {
					//2組のカード情報をもつ配列を生成
					sameCards = new Card[PAIR_CARDS];
					//加えられたカードを除外する
					sameCards[INDEX_NUMBER_ZERO] = (Card) myHand.remove(lastIndex);
					//加えられたカードと同じ数字のカードを除外する
					sameCards[INDEX_NUMBER_ONE] = (Card) myHand.remove(i);
					//全体を抜け出る
					break;
				}
			}
		}
		//同じカードを返却
		return sameCards;
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
		int handSize = myHand.size();
		//手札がある場合
		if (handSize > 0) {
			//手札の枚数分カードを表示
			for (int i = 0; i < handSize; i++) {
				//カード情報を取得
				Card myCard = (Card) myHand.get(i);
				//カード情報を取得
				string.append(myCard);
				//空白を出力
				string.append(" ");
			}
		}
		//文字列表現を返却
		return string.toString();
	}

}
