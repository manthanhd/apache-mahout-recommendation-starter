package com.manthanhd.mahoutstarter;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Starter {

    private UserBasedRecommender recommender;

    public Starter() {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("dataset.csv").getFile());
            DataModel dataModel = new FileDataModel(file);
            UserSimilarity userSimilarity = new PearsonCorrelationSimilarity(dataModel);
            UserNeighborhood userNeighborhood = new ThresholdUserNeighborhood(0.2, userSimilarity, dataModel);
            recommender = new GenericUserBasedRecommender(dataModel, userNeighborhood, userSimilarity);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (TasteException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static void main(String[] args) throws TasteException {
        Starter starter = new Starter();
        starter.recommendFor(2, 3);
    }

    public void recommendFor(int userId, int recommendationCount) throws TasteException {
        List<RecommendedItem> recommendations = recommender.recommend(userId, recommendationCount);
        if (recommendations == null || recommendations.size() == 0) {
            System.out.println(String.format("No recommendations for userId %s", userId));
        } else {
            for (RecommendedItem recommendation : recommendations) {
                System.out.println(recommendation);
            }
        }
    }

}