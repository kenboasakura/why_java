package work7_3;

/*クラス名:OldMaidHand
 *概要:ババ抜きの手札を管理
 *作成者:K.Asakura
 *作成日:2024/07/02
 */
public class OldMaidHand extends Hand{
	
	/*関数名:findSameNumberCard
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
		int numberOfCards = getMyHand().size();
		//同じカードを格納する配列を規定値で宣言
		Card[] sameCards = null;
		//カードがある場合
		if (numberOfCards > 0) {
			//末尾のインデックスを最後に追加されたカードで初期化して宣言
			int lastIndex = numberOfCards + ADJUSTMENT_INDEX;
			//最後に加えられたカードを取得
			Card lastAddedCard = (Card) getMyHand().get(lastIndex);
			//最後に加えられたカード番号を取得
			int lastAddedCardNumber = lastAddedCard.getNumber();
			//同じカード番号を探す
			for (int i = 0; i < lastIndex; i++) {
				//自分の手札を取得
				Card myCard = (Card) getMyHand().get(i);
				//同じカードを除外
				if (myCard.getNumber() == lastAddedCardNumber) {
					//2組のカード情報をもつ配列を生成
					sameCards = new Card[PAIR_CARDS];
					//加えられたカードを除外する
					sameCards[INDEX_NUMBER_ZERO] = (Card) getMyHand().remove(lastIndex);
					//加えられたカードと同じ数字のカードを除外する
					sameCards[INDEX_NUMBER_ONE] = (Card) getMyHand().remove(i);
					//全体を抜け出る
					break;
				}
			}
		}
		//同じカードを返却
		return sameCards;
	}

}
