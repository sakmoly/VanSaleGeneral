package com.van.sale.vansale.adapter;//package com.example.user.alumini.Models;
//

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.van.sale.vansale.R;
import com.van.sale.vansale.VanGlobals;
import com.van.sale.vansale.model.SalesInvoiceItemClass;

import java.util.List;


/**
 * Created by LEN on 2/16/2018.
 */

public class SelectedInvoiceRecyclerViewDetailAdapter extends RecyclerView.Adapter<SelectedInvoiceRecyclerViewDetailAdapter.MyViewHolder> {

    private Context mContext;
    private List<SalesInvoiceItemClass> cartList;
    private RecyclerView mRecyclerView;
    Boolean isAssetRequired;

    public SelectedInvoiceRecyclerViewDetailAdapter(Context mContext, List<SalesInvoiceItemClass> cartList) {
        this.cartList = cartList;
        this.mContext = mContext;
        isAssetRequired=((VanGlobals)mContext).getIsasset_reqd();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View itemView = LayoutInflater.from(mContext)
                .inflate(R.layout.selected_invoice_item_list, parent, false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {


        holder.item_asset_tv.setText("Freezer # :"+cartList.get(position).getINVOICE_ITEM_ASSET());
        holder.item_name_tv.setText(cartList.get(position).getINVOICE_ITEM_ITEMNAME());
        holder.item_code_tv.setText("Code : " + cartList.get(position).getINVOICE_ITEM_ITEMCODE());
        holder.item_qty_tv.setText("Qty : " + cartList.get(position).getINVOICE_ITEM_QTY());
        holder.total_amount.setText("₹" + (cartList.get(position).getINVOICE_ITEM_RATE()) * cartList.get(position).getINVOICE_ITEM_QTY());



    }


    @Override
    public int getItemCount() {

        return cartList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView item_name_tv, item_code_tv, item_qty_tv, total_amount,item_asset_tv;
        private LinearLayout complete_click, delete_item;


        public MyViewHolder(View view) {
            super(view);
            item_asset_tv=(TextView)view.findViewById(R.id.item_asset_tv) ;
            if(!isAssetRequired)
                item_asset_tv.setVisibility(View.INVISIBLE);
            item_name_tv = (TextView) view.findViewById(R.id.item_name_tv);
            item_code_tv = (TextView) view.findViewById(R.id.item_code_tv);
            item_qty_tv = (TextView) view.findViewById(R.id.item_qty_tv);
            total_amount = (TextView) view.findViewById(R.id.total_amount);

        }


    }
}