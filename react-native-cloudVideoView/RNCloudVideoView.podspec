
Pod::Spec.new do |s|
  s.name         = "RNCloudVideoView"
  s.version      = "1.0.0"
  s.summary      = "RNCloudVideoView"
  s.description  = <<-DESC
                  RNCloudVideoView
                   DESC
  s.homepage     = "https://github.com/jianglingzhi666/react-native-cloudVideoView/tree/master/react-native-cloudVideoView"
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "author@domain.cn" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/author/RNCloudVideoView.git", :tag => "master" }
  s.source_files  = "ios/**/*.{h,m}"
  s.requires_arc = true


  s.dependency "React"
  s.dependency 'SuperPlayer', "~> 3.5.0"
  #s.dependency "others"

end

  
