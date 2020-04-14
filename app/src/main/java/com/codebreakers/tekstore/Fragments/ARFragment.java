package com.codebreakers.tekstore.Fragments;



import android.os.Build;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.codebreakers.tekstore.R;
import com.google.ar.core.Anchor;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


public class ARFragment extends Fragment {
    private ArFragment arFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ar,container,false);
        arFragment= (ArFragment) getChildFragmentManager().findFragmentById(R.id.fragment);

        assert arFragment != null;
        arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {
            createViewRenderable(hitResult.createAnchor());
            Anchor anchor =hitResult.createAnchor();

//            ModelRenderable.builder()
//                    .setSource(getContext(), Uri.parse("skyscraper.sfb"))
//                    .build()
//                    .thenAccept(modelRenderable -> addModeltoScene(anchor,modelRenderable))
//                    .exceptionally(throwable -> {
//                        AlertDialog.Builder builder =new AlertDialog.Builder(getContext());
//                        builder.setMessage(throwable.getMessage()).show();
//                    return null;
//                    });
        });

        return view;
    }
    private void addModeltoScene(Anchor anchor, ModelRenderable modelRenderable)
    {
        AnchorNode anchorNode=new AnchorNode( anchor);
        TransformableNode transformableNode=new TransformableNode(arFragment.getTransformationSystem());
        transformableNode.setParent(anchorNode);
        transformableNode.setRenderable(modelRenderable);
        arFragment.getArSceneView().getScene().addChild(anchorNode);
        transformableNode.select();
    }

    private void createViewRenderable(Anchor anchor) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            ViewRenderable
                    .builder()
                    .setView(getContext(), R.layout.text)
                    .build()
                    .thenAccept(new Consumer<ViewRenderable>() {
                        @Override
                        public void accept(ViewRenderable viewRenderable) {
                            ARFragment.this.addtoScene(viewRenderable, anchor);
                        }
                    });
        }
    }
    private void addtoScene(ViewRenderable viewRenderable, Anchor anchor)
    {
        AnchorNode anchorNode=new AnchorNode(anchor);
        anchorNode.setRenderable(viewRenderable);
        arFragment.getArSceneView().getScene().addChild(anchorNode);
        View view=viewRenderable.getView();
        ViewPager viewPager=view.findViewById(R.id.viewPager);
        List<Integer> images =new ArrayList<>();
        images.add(R.drawable.ic_avatar);



        Adapter adapter=new Adapter(images);
        viewPager.setAdapter(adapter);


    }
    class Adapter extends PagerAdapter
    {
        List<Integer> images;
        Adapter(List<Integer>images)
        {
            this.images=images;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            View view= getLayoutInflater().inflate(R.layout.item,container,false);
            ImageView imageView=view.findViewById(R.id.imageView);
            imageView.setImageResource(images.get(position));
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((ImageView)object);        }

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }
    }
}
