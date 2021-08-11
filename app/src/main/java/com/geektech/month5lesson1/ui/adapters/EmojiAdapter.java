package com.geektech.month5lesson1.ui.adapters;

import android.graphics.Color;
import android.location.GnssAntennaInfo;
import android.net.sip.SipSession;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.month5lesson1.R;
import com.geektech.month5lesson1.domain.Card;
import com.geektech.month5lesson1.ui.EmojiGame;

import java.util.List;

public class EmojiAdapter extends RecyclerView.Adapter<EmojiAdapter.EmojiViewHolder> {

    private static EmojiGame emojiGame = new EmojiGame();
    private static EmojiViewHolder.Listener listener;

    public EmojiAdapter(EmojiViewHolder.Listener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public EmojiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new EmojiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmojiViewHolder holder, int position) {
        holder.onBind(emojiGame.getCards().get(position));
    }

    @Override
    public int getItemCount() {
        return emojiGame.getCards().size();
    }

    public static class EmojiViewHolder extends RecyclerView.ViewHolder {

        private TextView tvCard;

        public EmojiViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCard = itemView.findViewById(R.id.tv_card);
        }

        public void onBind(Card<String> card) {
            if (card.isFaceUp()) {
                tvCard.setText(card.getContent());
                tvCard.setBackgroundColor(Color.WHITE);
            } else {
                tvCard.setText("");
                tvCard.setBackgroundColor(Color.BLUE);
            }

            itemView.setOnClickListener(v -> {
                listener.choose();
                emojiGame.choose(card);

                for (int i = 0; i < emojiGame.getCards().size(); i++) {
                    if (emojiGame.getCards().get(i).isMatch()) {
                        emojiGame.getCards().get(i).setFaceUp(true);
                        emojiGame.getCards().remove(i);
                        if (emojiGame.getCards().isEmpty()){
                            Toast.makeText(itemView.getContext(), "Game is over!",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });

        }

        public interface Listener {
            void choose();
        }
    }
}
