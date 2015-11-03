package com.group6a_inclass08.group6a_inclass08;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.DeleteCallback;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Arunkumar's on 11/2/2015.
 */
public class MessageAdapter extends ArrayAdapter<ParseObject> {
    TextView fCommonTextView;
    ImageView fImageView;

    static Context fContext;
    int resource;

    List<ParseObject> messages;

    public MessageAdapter(Context context, int resource, List<ParseObject> objects) {
        super(context, resource, objects);

        this.fContext = context;
        this.resource = resource;
        this.messages = objects;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) fContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resource,parent,false);
        }

        final ParseObject obj = messages.get(position);

        //Set Names
        ParseUser user = obj.getParseUser("createdBy");
        String name = user.getString("Name");
        fCommonTextView = (TextView) convertView.findViewById(R.id.textViewmFirstName);
        fCommonTextView.setText(name);


        //Set Message
        fCommonTextView = (TextView) convertView.findViewById(R.id.textViewMessageBody);
        fCommonTextView.setText(obj.getString("message"));


        //Set Date
        String date = obj.getCreatedAt().toString();

        fCommonTextView = (TextView) convertView.findViewById(R.id.textViewDate);
        fCommonTextView.setText(date);


        //OnClick Delete
        fImageView = (ImageView) convertView.findViewById(R.id.imageViewDeleteButton);
        fImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                obj.deleteInBackground(new DeleteCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e==null){
                            MessageActivity.userMessages.remove(position);
                            notifyDataSetChanged();

                        }

                    }
                });
            }
        });

        return convertView;
    }

}
