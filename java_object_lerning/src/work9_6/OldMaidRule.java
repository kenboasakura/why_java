package work9_6;
//TrumpパッケージのCardクラスをインポート
import Trump.Card;
import Trump.Hand;
import Trump.Rule;
import Trump.Table;

/*クラス名:OldMaidRule
 *概要:ばば抜きのルールを管理
 *作成者:K.Asakura
 *作成日:2024/07/03
 */
public class OldMaidRule implements Rule {

	/*関数名:findCandidate
	 *概要:同じ数字のカード見つけてを返却する
	 *引数:プレイヤーの手(playerHand)、ばば抜きのテーブル(gametTable)
	 *戻り値:同じ数字のカード(Card型の配列)
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public Card[] findCandidate(Hand playerHand, Table gametTable) {
		//ペアのカードを表す整数を定数化
		final int PAIR_CARDS = 2;
		//先頭のインデックスを定数化
		final int INDEX_NUMBER_ZERO = 0;
		//先頭から2番目のインデックスを定数化
		final int INDEX_NUMBER_ONE = 1;
		//手札の枚数を初期化して宣言
		int numberOfCards = playerHand.getNumberOfCards();
		//同じ数字のカードを格納する配列を宣言
		Card[] sameCards = null;
		//手札がある場合
		if (numberOfCards > 0) {
			//末尾のインデックスを初期化して宣言
			int lastIndex = numberOfCards - 1;
			//最後に加えられたカードを見る
			Card lastAddCard = (Card) playerHand.lookCard(lastIndex);
			//最後に加えられたカードの数字を初期化して宣言
			int lastAddeCardNumber = lastAddCard.getNumber();
			//同じ数字のカードを見つけ、そのカードを引いて代入
			for (int i = 0; i < lastIndex; i++) {
				//プレイヤーの手札を表す変数を宣言
				Card handCard = (Card) playerHand.lookCard(i);
				//同じ数字が見つかった場合
				if (handCard.getNumber() == lastAddeCardNumber) {
					//同じ数字のカードを格納する配列を生成
					sameCards = new Card[PAIR_CARDS];
					//同じ数字のカードを手札から引いて代入
					sameCards[INDEX_NUMBER_ZERO] = (Card) playerHand.pickCard(i);
					//同じ数字のカードを手札から引いて代入
					sameCards[INDEX_NUMBER_ONE] = (Card) playerHand.pickCard(lastIndex-1);
					//if文を抜け出す
					break;
				}
			}
		}
		//同じ数字のカードを返却
		return sameCards;
	}

}
