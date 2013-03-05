require 'test_helper'

class ItemFeaturesControllerTest < ActionController::TestCase
  setup do
    @item_feature = item_features(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:item_features)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create item_feature" do
    assert_difference('ItemFeature.count') do
      post :create, item_feature: @item_feature.attributes
    end

    assert_redirected_to item_feature_path(assigns(:item_feature))
  end

  test "should show item_feature" do
    get :show, id: @item_feature.to_param
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @item_feature.to_param
    assert_response :success
  end

  test "should update item_feature" do
    put :update, id: @item_feature.to_param, item_feature: @item_feature.attributes
    assert_redirected_to item_feature_path(assigns(:item_feature))
  end

  test "should destroy item_feature" do
    assert_difference('ItemFeature.count', -1) do
      delete :destroy, id: @item_feature.to_param
    end

    assert_redirected_to item_features_path
  end
end
